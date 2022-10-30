package com.example.notificationservice.service;

import com.example.notificationservice.model.NotificationRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MailService {
    private final JavaMailSender javaMailSender;

    public void sendEmail(String toEmail) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom("emre.sevindik99@gmail.com");
        mailMessage.setTo(toEmail);
        mailMessage.setText("Hoş geldin "+toEmail);
        mailMessage.setText("Uygulamaya Hoş Geldiniz..");

        javaMailSender.send(mailMessage);
        log.info("Mail send successfully...");
    }
}
