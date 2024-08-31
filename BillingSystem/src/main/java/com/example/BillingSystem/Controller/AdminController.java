package com.example.BillingSystem.Controller;

import com.example.BillingSystem.Dto.CustomerResponseDto;
import com.example.BillingSystem.Dto.InvoiceResponseDto;
import com.example.BillingSystem.Dto.ServiceResponseDto;
import com.example.BillingSystem.Service.CustomerService;
import com.example.BillingSystem.Service.InvoiceService;
import com.example.BillingSystem.Service.ServiceService;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/Admin")
//@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    private final CustomerService customerService;
    private final InvoiceService invoiceService;
    private final ServiceService serviceService;

    public AdminController(CustomerService customerService, InvoiceService invoiceService, ServiceService serviceService) {
        this.customerService = customerService;
        this.invoiceService = invoiceService;
        this.serviceService = serviceService;
    }

    @GetMapping("/Customers/All")
    public List<CustomerResponseDto> findAllCustomers() {
        return customerService.findAllCustomers();
    }

    @GetMapping("/Invoices/All")
    public List<InvoiceResponseDto> findAllInvoice() {
        return invoiceService.findAllInvoices();
    }

    @GetMapping("/BillingServices/All")
    public List<ServiceResponseDto> findAllServices() {
        return serviceService.findAllServices();
    }
}
