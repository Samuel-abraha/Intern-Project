package com.example.BillingSystem.Controller;


import com.example.BillingSystem.Dto.InvoiceItemResponseDto;
import com.example.BillingSystem.Dto.InvoiceResponseDto;
import com.example.BillingSystem.Service.InvoiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/Invoices")
public class InvoiceController {


    private final InvoiceService invoiceService;

    public InvoiceController( InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("/{Invoice_customer_phonenumber}")
    public InvoiceResponseDto findInvoiceByCustomerPhonenumber(
            @PathVariable("Invoice_customer_phonenumber") String phoneNumber
    ){
        return invoiceService.findInvoiceByCustomerPhonenumber(phoneNumber);
    }

    @GetMapping("/{InvoiceItem_customer_phonenumber}")
    public InvoiceItemResponseDto findInvoiceItemByCustomerPhonenumber(
            @PathVariable("InvoiceItem_customer_phonenumber") String phoneNumber
    ){
        return invoiceService.findInvoiceItemByCustomerPhonenumber(phoneNumber);
    }



}
