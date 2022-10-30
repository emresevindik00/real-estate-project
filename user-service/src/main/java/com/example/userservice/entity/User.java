package com.example.userservice.entity;

import com.example.userservice.enums.UserType;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @Enumerated(EnumType.STRING)
    private UserType userType;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    @NotNull
    private String email;
    private String password;
    private String phoneNumber;

}
