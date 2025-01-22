package org.example;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;

public class EmailSendAllAttributes {
    public static void main(String[] args) {
        // Sender's email credentials
        final String fromEmail = "97.bhattacharjee.ullash@gmail.com";
        final String password = "wnky onjy qver ncrz";

        // Recipients
        String[] toRecipients = {"turja997@gmail.com"}; // To recipients
        String[] ccRecipients = {"turjo998.aust@gmail.com"};             // CC recipients
        String[] bccRecipients = {"turjo998.aust@gmail.com"};          // BCC recipients

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

            // Add TO recipients
            Address[] toAddresses = new Address[toRecipients.length];
            for (int i = 0; i < toRecipients.length; i++) {
                toAddresses[i] = new InternetAddress(toRecipients[i]);
            }
            message.setRecipients(Message.RecipientType.TO, toAddresses);

            // Add CC recipients
            Address[] ccAddresses = new Address[ccRecipients.length];
            for (int i = 0; i < ccRecipients.length; i++) {
                ccAddresses[i] = new InternetAddress(ccRecipients[i]);
            }
            message.setRecipients(Message.RecipientType.CC, ccAddresses);

            // Add BCC recipients
            Address[] bccAddresses = new Address[bccRecipients.length];
            for (int i = 0; i < bccRecipients.length; i++) {
                bccAddresses[i] = new InternetAddress(bccRecipients[i]);
            }
            message.setRecipients(Message.RecipientType.BCC, bccAddresses);

            // Email subject and text
            message.setSubject("Email with CC, BCC, and Attachment");
            message.setText("Please find the attached PDF file.");

            // Create a multipart message
            Multipart multipart = new MimeMultipart();

            // Add text part
            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setText("Hello, this is an email with CC, BCC, and a PDF attachment sent from a simple Java application!");
            multipart.addBodyPart(textPart);

            // Add attachment part
            MimeBodyPart attachmentPart = new MimeBodyPart();
            String filePath = "E:/Explore_New_Techs/java-mail/Ullash Bhattacharjee.pdf"; // File path

            File file = new File(filePath);

            if (file.exists()) {
                attachmentPart.attachFile(file);
                multipart.addBodyPart(attachmentPart);
            } else {
                System.out.println("Attachment file not found: " + filePath);
                return; // Stop the execution if the file is not found
            }

            // Set the complete message parts
            message.setContent(multipart);

            // Send the email
            Transport.send(message);

            System.out.println("Email sent successfully with CC and BCC!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
