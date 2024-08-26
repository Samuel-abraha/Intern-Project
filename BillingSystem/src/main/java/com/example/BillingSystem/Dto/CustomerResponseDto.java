package com.example.BillingSystem.Dto;

public record CustomerResponseDto(
        String fullname,
        String email,
        String phonenumber,
        String username

) {
}
