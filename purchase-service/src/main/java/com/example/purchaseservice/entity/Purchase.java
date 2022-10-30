package com.example.purchaseservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Purchase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private int purchaseId;
    private int userId;
    @ManyToOne(fetch = FetchType.LAZY)
    private AdvertPackage advertPackage;
    private ZonedDateTime purchaseDate;
    private Long paymentId;
}
