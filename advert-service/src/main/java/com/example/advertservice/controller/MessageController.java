package com.example.advertservice.controller;

import com.example.advertservice.service.EventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
@Slf4j
public class MessageController {

    private EventService eventService;

    public MessageController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public void publish(@RequestBody String message) {
        eventService.sendMessage(message);
        log.info("Message: "+message);

    }
}
