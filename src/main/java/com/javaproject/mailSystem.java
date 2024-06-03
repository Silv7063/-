package com.javaproject;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.Properties;

public class mailSystem {
    public static void sendEmail(String to, String from, String host, String subject, String text) {
        // Set properties
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.port", "587");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");

        // Create a session
        Session session = Session.getInstance(properties, new jakarta.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("ckkhk0001@gmail.com", "gseriepnzeuomnpj"); // Provide the actual username and password
            }
        });

        try {
            // Create a default MimeMessage object
            MimeMessage message = new MimeMessage(session);

            // Set From: header field
            message.setFrom(new InternetAddress(from));

            // Set To: header field
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject(subject);

            // Set the actual message
            message.setText(text);

            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

    public void mailMsg(String subject, String text) {
        String to = "ckkhk0001@gmail.com"; // recipient email
        String from = "ckkhk0001@gmail.com"; // sender email
        String host = "smtp.gmail.com"; // mail server host
        sendEmail(to, from, host, subject, text);
    }
}
