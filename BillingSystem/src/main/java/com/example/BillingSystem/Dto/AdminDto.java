package com.example.BillingSystem.Dto;

import jakarta.validation.constraints.NotEmpty;

public record AdminDto(
        @NotEmpty
        String fullname,
        @NotEmpty
        String email,
        @NotEmpty
        String phonenumber,
        UserDto userDto

) {
}
