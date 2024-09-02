package com.example.BillingSystem.Dto;

import jakarta.validation.constraints.NotEmpty;

import java.math.BigDecimal;

public record ServiceDto(
        @NotEmpty
        String serviceName,
//        @NotNull
        BigDecimal unitPrice,
        @NotEmpty
        String unitOfMeasure

) {
}
