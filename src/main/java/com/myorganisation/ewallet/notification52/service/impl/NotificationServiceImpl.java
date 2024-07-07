package com.myorganisation.ewallet.notification52.service.impl;

import com.myorganisation.ewallet.notification52.service.NotificationService;
import com.myorganisation.ewallet.notification52.service.resource.NotificationMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    JavaMailSenderImpl javaMailSender;

    Logger logger = LoggerFactory.getLogger(NotificationServiceImpl.class);

    @Override
    public void sendNotification(NotificationMessage notificationMessage) {
        
        try {
            sendEmail(notificationMessage);
        } catch(Exception ex) {
            
        }
        
        try {
            sendSms(notificationMessage);
        } catch(Exception ex) {
            
        }

    }

    private void sendSms(NotificationMessage notificationMessage) {
        logger.info("Logic to send SMS here!");
    }

    private void sendEmail(NotificationMessage notificationMessage) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(notificationMessage.getToEmail());
        mailMessage.setSubject(notificationMessage.getSubject());
        mailMessage.setText(notificationMessage.getBody());
        javaMailSender.send(mailMessage);
    }
}
