package com.example.BillingSystem.Dto;

import java.math.BigDecimal;

public record PaymentDto(

        Long id,
        BigDecimal paid_amount
) {
}


