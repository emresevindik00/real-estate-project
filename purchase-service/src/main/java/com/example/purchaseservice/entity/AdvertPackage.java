package com.example.purchaseservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Currency;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdvertPackage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private int advertId;
    private String name;
    private Integer advertNumber;
    private Integer duration;
    private Integer price;
    private Currency currency;
}
