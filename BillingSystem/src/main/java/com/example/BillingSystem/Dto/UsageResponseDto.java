package com.example.BillingSystem.Dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record UsageResponseDto(

        BigDecimal usageAmount,
        LocalDate billingPeriod,    //the month for the billing
        LocalDate usageDate,
        String customerName,
        String customerPhoneNumber,
        String billingServiceName

) {
}
