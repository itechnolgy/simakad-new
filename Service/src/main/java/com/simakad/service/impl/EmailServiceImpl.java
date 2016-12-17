package com.simakad.service.impl;

import com.simakad.dao.constant.EmailType;
import com.simakad.dao.constant.UserType;
import com.simakad.dao.entity.Users;
import com.simakad.service.EmailService;
import org.springframework.stereotype.Component;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
/**
 * Created by HighDream on 10/23/2016.
 */
@Component
public class EmailServiceImpl implements EmailService {
    private Session session;
    private Properties props;
    private String email = "sttj.simakad@gmail.com";
    private String password = "sttjs1makad";

    public EmailServiceImpl () {
        props = new Properties();
//        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.host", "localhost");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                  "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(email, password);//change accordingly
                    }
                });
    }


    @Override
    public void sendMessage(EmailType emailType, UserType userType, String recepient, Object messageObject) {
        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(email));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            msg.setSubject(messageSubjectTemplate(emailType, userType));
            msg.setText(messageBodyTemplate(emailType, userType, messageObject));

            Transport.send(msg);
        } catch (Exception e) {
            System.out.print("Error when send message. Ex =" + e.getMessage());
        }

    }

    private String messageSubjectTemplate(EmailType emailType, UserType userType) {
        String subject = "";
        switch (emailType) {
            case REGISTRATION :
                switch (userType){
                    case NEW_STUDENT:
                        subject = "STTJ - Username & Password Portal Penerimaan Mahasiswa Baru ";
                        break;
                    case LECTURE:
                        subject = "STTJ - Username & Password Portal Informasi Akademik";
                        break;
                    case ACADEMIC:
                        subject = "STTJ - Username & Password Portal Informasi Akademik";
                        break;
                }
                break;
            case FORGOT_PASSWORD:
                subject = "STTJ - Reset Password ";
                break;
            case ACCEPTED_STUDENT:
                subject = "STTJ - Username & Password Mahasiswa";
        }

        return subject;
    }

    private String messageBodyTemplate(EmailType emailType, UserType userType, Object messageObject) {
        StringBuilder builder = new StringBuilder();
        Users users = (Users) messageObject;
        switch (emailType) {
            case REGISTRATION :
                switch (userType){
                    case NEW_STUDENT:
                        builder.append("Terima kasih telah melakukan pendaftaran mahasiswa baru STTJ \n");
                        builder.append("Berikut username dan password untuk melakukan login ke Portal Mahasiswa Baru STTJ \n");
                        break;
                    case LECTURE:
                        builder.append("Terima kasih telah melakukan pendaftaran Dosen STTJ \n");
                        builder.append("Berikut username dan password untuk melakukan login ke Portal Akademik STTJ \n");
                        break;
                    case ACADEMIC:
                        builder.append("Terima kasih telah melakukan pendaftaran Staff Akademik STTJ \n");
                        builder.append("Berikut username dan password untuk melakukan login ke Portal Akademik STTJ \n");
                        break;
                }
                builder.append("Username    :   " + users.getUsername() + " \n");
                builder.append("Password    :   " + users.getDecryptPass() + " \n");
                break;
            case FORGOT_PASSWORD:
                Users usersForgot = (Users) messageObject;
                builder.append("Reset Password \n");
                builder.append("Berikut password baru anda \n");
                builder.append("Username    :   " + usersForgot.getUsername() + " \n");
                builder.append("Password    :   " + usersForgot.getDecryptPass() + " \n");
                break;
            case ACCEPTED_STUDENT:
                builder.append("Kami ucapakan selamat datang kepada saudara/saudari sebagai bagian dari mahasiswa Sekolah Teologi Jakarta" + " \n");
                builder.append("Berikut username dan password untuk melakukan login ke Portal Mahasiswa STTJ \n");
                builder.append("Username    :   " + users.getUsername() + " \n");
                builder.append("Password    :   " + users.getDecryptPass() + " \n");
        }

        return builder.toString();
    }

//    public static class RegistrationMessageModel {
//        public String username;
//        public String password;
//    }
}
