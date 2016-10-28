package com.simakad.service;

import com.simakad.dao.constant.EmailType;
import com.simakad.dao.entity.Users;
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
    private String email = "exxecusion@gmail.com";
    private String password = "passtykontel";

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
    public void sendMessage(EmailType emailType, String recepient, Object messageObject) {
        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(email));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            msg.setSubject(messageSubjectTemplate(emailType));
            msg.setText(messageBodyTemplate(emailType, messageObject));

            Transport.send(msg);
        } catch (Exception e) {
            System.out.print("Error when send message. Ex =" + e.getMessage());
        }

    }

    private String messageSubjectTemplate(EmailType emailType) {
        String subject = "";
        switch (emailType) {
            case REGISTRATION :
                subject = "STTJ - Username & Password Portal Mahasiswa Baru ";
                break;
            case FORGOT_PASSWORD:
                subject = "STTJ - Reset Password ";
                break;
        }

        return subject;
    }

    private String messageBodyTemplate(EmailType emailType, Object messageObject) {
        StringBuilder builder = new StringBuilder();
        switch (emailType) {
            case REGISTRATION :
                Users users = (Users) messageObject;
                builder.append("Terima kasih telah melakukan pendaftaran mahasiswa baru STTJ \n");
                builder.append("Berikut username dan password untuk melakukan login ke portal mahasiswa baru STTJ \n");
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
        }

        return builder.toString();
    }

//    public static class RegistrationMessageModel {
//        public String username;
//        public String password;
//    }
}
