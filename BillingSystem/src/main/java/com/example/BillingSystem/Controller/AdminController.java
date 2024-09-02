package com.example.BillingSystem.Controller;

import com.example.BillingSystem.Dto.*;
import com.example.BillingSystem.Service.AdminService;
import com.example.BillingSystem.Service.CustomerService;
import com.example.BillingSystem.Service.InvoiceService;
import com.example.BillingSystem.Service.ServiceService;
//import org.springframework.security.access.prepost.PreAuthorize;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Admin")
//@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    private final AdminService adminService;
    private final CustomerService customerService;
    private final InvoiceService invoiceService;
    private final ServiceService serviceService;

    public AdminController(AdminService adminService, CustomerService customerService, InvoiceService invoiceService, ServiceService serviceService) {
        this.adminService = adminService;
        this.customerService = customerService;
        this.invoiceService = invoiceService;
        this.serviceService = serviceService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addAdmin(
            @Valid @RequestBody AdminDto dto
    ){
        return adminService.addAdmin(dto);
    }

    // Fetch admin profile by username
    @GetMapping("/findByUsername/{username}")
    public ResponseEntity<AdminResponseDto> getAdminProfileByUsername(@PathVariable String username) {
        return adminService.getAdminProfileByUsername(username);
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
