package com.example.lms.dto;

public record LoginResponse(
    String token,
    String refreshToken
) {
}
