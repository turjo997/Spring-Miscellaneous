package org.example;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSender {
    public static void main(String[] args) {

        final String fromEmail = "97.bhattacharjee.ullash@gmail.com";
        final String password = "wnky onjy qver ncrz";


        String toEmail = "turja997@gmail.com";

        // SMTP server configuration
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com"); // SMTP host
        properties.put("mail.smtp.port", "587");           // TLS Port
        properties.put("mail.smtp.auth", "true");          // Enable authentication
        properties.put("mail.smtp.starttls.enable", "true"); // Enable TLS

        // Create a session with authentication
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            // Create an email message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("Test Email");
            message.setText("Hello, this is a test email sent from a simple Java application!");

            // Send the email
            Transport.send(message);

            System.out.println("Email sent successfully!");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
