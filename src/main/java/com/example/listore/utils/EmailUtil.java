package com.example.listore.utils;


import com.example.listore.models.utils.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class EmailUtil {

    private static String email;
    private static String password;

    // variables para la creacion del correo

    private static Properties mProperties;
    private static Session mSession;
    private static MimeMessage mCorreo;

    private static Transport mTransport;

    @Autowired
    private void setCredential(Environment env){
        email = env.getProperty("listore.email");
        password = env.getProperty("listore.password");
    }

    public static void initializeEmailUtil(){
        mProperties = new Properties();
        mProperties.put("mail.smtp.host", "smtp.gmail.com");
        mProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        mProperties.setProperty("mail.smtp.starttls.enable", "true");
        mProperties.setProperty("mail.smtp.port", "587");
        mProperties.setProperty("mail.smtp.user",email);
        mProperties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        mProperties.setProperty("mail.smtp.auth", "true");

        mSession = Session.getDefaultInstance(mProperties);

        try {
            mTransport = mSession.getTransport("smtp");
            mTransport.connect(email, password);
            mCorreo = new MimeMessage(mSession);
            mCorreo.setFrom(new InternetAddress(email));
        } catch (AddressException ex) {
            System.out.println(ex);
        } catch (MessagingException ex) {
            System.out.println(ex);
        }
    }


    public static void sendEmail(Email email){
        try {
            mCorreo.setRecipient(Message.RecipientType.TO, new InternetAddress(email.getEmailTo()));
            mCorreo.setSubject(email.getSubject());
            mCorreo.setText(email.getContent(), "ISO-8859-1", "html");
            mTransport.sendMessage(mCorreo, mCorreo.getRecipients(Message.RecipientType.TO));
            mTransport.close();

            System.out.println("Correo enviado al usuario");
        } catch (NoSuchProviderException ex) {
            System.out.println(ex);
        } catch (MessagingException ex) {
            System.out.println(ex);
        }

    }

}
