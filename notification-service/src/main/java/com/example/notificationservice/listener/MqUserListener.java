package com.example.notificationservice.listener;

import com.example.notificationservice.service.MailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MqUserListener {

    private final Logger logger = LoggerFactory.getLogger(MqUserListener.class);

    @Autowired
    private MailService mailService;

    @RabbitListener(queues = "${rabbitmq.queue}")
    public void getQueueMail(String email) {
        logger.info("Mail in queue: "+email);
        mailService.sendEmail(email);
    }
}
