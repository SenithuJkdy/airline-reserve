package com.example.flight_reservation.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    private int id;
    private String email;
    private String password;

    // Getters and setters
}

