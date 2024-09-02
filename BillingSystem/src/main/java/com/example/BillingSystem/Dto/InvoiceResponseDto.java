package com.example.BillingSystem.Dto;


import java.math.BigDecimal;
import java.time.LocalDate;

public record InvoiceResponseDto(

        String customerFullName,
        String phoneNumber,
        String serviceName,
        LocalDate invoiceDate,
        LocalDate billingPeriod,
        BigDecimal totalAmount


) {
}
