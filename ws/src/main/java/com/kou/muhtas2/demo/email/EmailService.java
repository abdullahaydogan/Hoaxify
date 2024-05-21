package com.kou.muhtas2.demo.email;

import jakarta.transaction.Transactional;
import lombok.Data;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Data
@Service
public class EmailService {


    @Transactional(rollbackOn = MailException.class)
    public void sendEmail(String email, String activationToken) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("MuhTas2@my-app.com");
            message.setTo(email);
            message.setSubject("Account Activation");
            message.setText("http://localhost:5173/activation/= " + activationToken);
            getJavaMailSender().send(message);
            System.out.println("The email was sent successfully.");
        } catch (MailException e) {
            System.err.println("An error occurred while sending the email: " + e.getMessage());
        }
    }

    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("paul.casper57@ethereal.email");
        mailSender.setPassword("kP8zmGN39n7NA4pgPd");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.smtp.starttls.enable", true);
        return mailSender;
    }

    String activationEmail = """
            <html>
                <body> 
                    <h1>Activate Account</h1>
                    <a href = "${url}">Click here </a>      
                </body> 
            </html>
            """;


}
