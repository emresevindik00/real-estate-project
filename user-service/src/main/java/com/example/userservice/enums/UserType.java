package com.example.userservice.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum UserType {
    INDIVIDUAL("Bireysel"), INSTITUTIONAL("Kurumsal");
    private final String screenLabel;
}
