package com.simakad.service;

//import com.sun.xml.internal.org.jvnet.mimepull.MIMEMessage;
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
    private String password = "passty";

    public EmailServiceImpl () {
        props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
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
    public void sendMessage(String recepient, String message) {
        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(email));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress("kovanchandra@gmail.com"));
            msg.setSubject("Ping");
            msg.setText("Hello, this is example of sending email  ");

            Transport.send(msg);
        } catch (Exception e) {

        }

    }


}
