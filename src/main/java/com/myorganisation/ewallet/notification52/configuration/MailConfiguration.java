package com.myorganisation.ewallet.notification52.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfiguration {

    @Value("${mail.username}")
    private String username;

    @Value("${mail.password}")
    private String password;

    @Bean
    public JavaMailSenderImpl getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setUsername(username);
        mailSender.setPassword(password);
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setProtocol("smtp");

        mailSender.getJavaMailProperties().setProperty("mail.smtp.starttls.enable", "true"); //TLS -> Transport Layer Security
        mailSender.getJavaMailProperties().setProperty("mail.smtp.auth", "true");

        return mailSender;
    }
}
