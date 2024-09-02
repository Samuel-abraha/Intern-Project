package com.example.BillingSystem.Dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


import java.math.BigDecimal;
import java.time.LocalDate;

public record UsageDto(
        @NotNull
        BigDecimal usageAmount,
        @NotNull
        LocalDate billingPeriod,
        @NotNull
        LocalDate usageDate,
        @NotEmpty
        String customerPhoneNumber,
        @NotEmpty
        String serviceName
) {
}
