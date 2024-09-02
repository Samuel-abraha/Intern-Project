package com.example.BillingSystem.Dto;

import jakarta.validation.constraints.NotEmpty;

public record CustomerDto(
        @NotEmpty
        String fullname,
        @NotEmpty
        String email,
        @NotEmpty
        String phonenumber,
        String address,
        UserDto userDto
) {
}
