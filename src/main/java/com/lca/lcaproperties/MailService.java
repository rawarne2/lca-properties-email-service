package com.lca.lcaproperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import javax.mail.Message;
//import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


@Service
public class MailService {

//    private JavaMailSender javaMailSender;
    private Transport transport;


    @Autowired
    public MailService() {
        System.out.print("starting mail service");
//        here first
//        this.javaMailSender = javaMailSender;
//        this.transport = transport;
    }


    public void sendEmail(User user, String emailRequest) throws MailException {

        System.out.print("starting to send email");
//
//
//        javaMailSender.send(mail);
        String to = "lcallcproperties@gmail.com";

        // Sender's email ID needs to be mentioned
        String from = "lcallcproperties@gmail.com";

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {
                System.out.print(System.getenv());
                return new PasswordAuthentication("lcallcproperties@gmail.com", System.getenv("gMailPassword"));
            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("Test Maintenance Request");

            // Now set the actual message
            message.setText(emailRequest);
//            message.setContent(message, "text/html");

            System.out.println("sending...");
            System.out.print(message);
            // Send message
            transport.send(message); // here
//            javaMailSender.send(message);
            System.out.println("Sent message successfully....");
//            return "Congratulations! Your mail has been send to the user.";
        } catch (MessagingException mex) {
            mex.printStackTrace();
//            return "Email request failed.";
        }
    }


//    public void sendEmailWithAttachment(User user) throws MailException, MessagingException {
//
//        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//
//        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
//
//        helper.setTo(user.getEmailAddress());
//        helper.setSubject("Testing Mail API with Attachment");
//        helper.setText("Please find the attached document below.");
//
//        ClassPathResource classPathResource = new ClassPathResource("Attachment.pdf");
//        helper.addAttachment(classPathResource.getFilename(), classPathResource);
//
//        javaMailSender.send(mimeMessage);
//    }

}
