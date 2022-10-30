package com.example.advertservice.entity;

import com.example.advertservice.enums.*;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class Advert implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Long advertNo;
    private String title;
    private String description;
    private Integer putForward;
    @Enumerated(EnumType.STRING)
    private Currency currency;
    private Double price;
    private Integer room;
    private Integer livingRoom;
    private Integer age;
    private Integer bathRoom;
    private String floor;
    private Integer numberOfFloor;
    private Double netSquareMeters;
    private Double squareMeters;
    @Enumerated(EnumType.STRING)
    private PublicationType publicationType;
    @Enumerated(EnumType.STRING)
    private BuildType buildType;
    @Enumerated(EnumType.STRING)
    private BuildState buildState;
    private Boolean active;
    private String roomAndLivingRoom;
    private int userId;
    @ManyToOne(fetch = FetchType.LAZY)
    private Address address;
    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
    private Category mainCategory;
    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
    private Category subCategory;
    @Enumerated(EnumType.STRING)
    private AdvertStatus advertStatus;
}
