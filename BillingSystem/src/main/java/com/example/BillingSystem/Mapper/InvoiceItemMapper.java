package com.example.BillingSystem.Mapper;

import com.example.BillingSystem.Dto.InvoiceItemResponseDto;
import com.example.BillingSystem.Entitys.InvoiceItem;
import org.springframework.stereotype.Service;

@Service
public class InvoiceItemMapper {
    public InvoiceItemResponseDto toInvoiceItemResponseDto(InvoiceItem invoiceItem){

        return new InvoiceItemResponseDto(
                invoiceItem.getCustomer().getFullname(),
                invoiceItem.getCustomer().getPhonenumber(),
                invoiceItem.getBillingService().getServiceName(),
                invoiceItem.getUsageAmount(),
                invoiceItem.getUnitPrice(),
                invoiceItem.getTotalPrice());

    }


}
