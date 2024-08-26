package com.example.BillingSystem.Dto;

import jakarta.validation.constraints.NotEmpty;

public record UserDto(
        @NotEmpty
        String username,
        @NotEmpty
        String password
) {
}
