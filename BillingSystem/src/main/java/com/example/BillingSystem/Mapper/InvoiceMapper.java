package com.example.BillingSystem.Mapper;


import com.example.BillingSystem.Dto.InvoiceResponseDto;
import com.example.BillingSystem.Entitys.Invoice;
import org.springframework.stereotype.Service;

@Service
public class InvoiceMapper {
    public InvoiceResponseDto toInvoiceResponseDto(Invoice invoice){

        return new InvoiceResponseDto(
                invoice.getCustomer().getFullname(),
                invoice.getCustomer().getPhonenumber(),
                invoice.getBillingService().getServiceName(),
                invoice.getInvoiceDate(),
                invoice.getBillingPeriod(),
                invoice.getTotalAmount());

    }
}
