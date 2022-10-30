package com.example.userservice.service;

import com.example.userservice.config.RabbitMqConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqService {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Autowired
    private RabbitMqConfig config;

    public void sendMessage(String email) {
        rabbitTemplate.convertAndSend(config.getExchange(), config.getRoutingKey(), email);
    }
}
