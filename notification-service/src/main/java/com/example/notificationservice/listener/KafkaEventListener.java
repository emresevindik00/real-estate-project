package com.example.notificationservice.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaEventListener {

    @KafkaListener(topics = "Emre", groupId = "groupId")
    public void listen(String event) {
        log.info("Event "+event+" created..!");
    }
}
