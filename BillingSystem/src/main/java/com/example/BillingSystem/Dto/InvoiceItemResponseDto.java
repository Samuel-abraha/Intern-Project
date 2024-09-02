package com.example.BillingSystem.Dto;

import java.math.BigDecimal;

public record InvoiceItemResponseDto(

        String customerFullName,
        String phoneNumber,
        String serviceName,
        BigDecimal usageAmount,
        BigDecimal unitPrice,
        BigDecimal totalPrice
) {
}
