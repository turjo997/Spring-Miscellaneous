package org.example;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;

public class EmailSenderWithAttachment {
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

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("Email with Attachment");
            message.setText("Please find the attached file.");

            Multipart multipart = new MimeMultipart();

            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setText("Hello, this is an email with an attachment sent from a simple Java application!");
            multipart.addBodyPart(textPart);

            MimeBodyPart attachmentPart = new MimeBodyPart();
            String filePath = "E:/Explore_New_Techs/java-mail/Ullash Bhattacharjee.pdf";
            File file = new File(filePath);

            if (file.exists()) {
                attachmentPart.attachFile(file);
                multipart.addBodyPart(attachmentPart);
            } else {
                System.out.println("Attachment file not found: " + filePath);
            }

            message.setContent(multipart);

            Transport.send(message);

            System.out.println("Email with attachment sent successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
