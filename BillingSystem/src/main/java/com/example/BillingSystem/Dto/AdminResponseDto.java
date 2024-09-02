package com.example.BillingSystem.Dto;

public record AdminResponseDto(
        String fullname,
        String email,
        String phonenumber,
        String username,
        String password
) {
}
