package com.example.notificationservice.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class NotificationRequest {
    public String subject;
    public String body;
}
