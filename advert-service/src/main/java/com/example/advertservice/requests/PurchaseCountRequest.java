package com.example.advertservice.requests;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class PurchaseCountRequest {
    private int purchaseCountId;
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;
    private Integer total;
    private int userId;
    private Integer remainingTotal;
}
