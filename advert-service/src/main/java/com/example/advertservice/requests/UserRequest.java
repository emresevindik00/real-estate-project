package com.example.advertservice.requests;

import com.example.advertservice.enums.UserType;
import lombok.Data;


@Data
public class UserRequest {
    private int userId;
    private UserType userType;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
}
