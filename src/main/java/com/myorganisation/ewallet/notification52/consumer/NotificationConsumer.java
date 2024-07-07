package com.myorganisation.ewallet.notification52.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myorganisation.ewallet.notification52.service.NotificationService;
import com.myorganisation.ewallet.notification52.service.resource.NotificationMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {

    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    NotificationService notificationService;

    @KafkaListener(topics = "NOTIFICATION", groupId = "notificationGrp")
    public void sendNotification(String message) {
        try {
            NotificationMessage notificationMessage = mapper.readValue(message, NotificationMessage.class);
            notificationService.sendNotification(notificationMessage);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

}
