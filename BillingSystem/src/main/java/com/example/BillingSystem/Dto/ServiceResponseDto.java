package com.example.BillingSystem.Dto;

import java.math.BigDecimal;

public record ServiceResponseDto(
        String serviceName,
        BigDecimal unitPrice,
        String unitOfMeasure
) {
}
