package com.example.BillingSystem.Controller;


import com.example.BillingSystem.Dto.CustomerDto;
import com.example.BillingSystem.Dto.CustomerResponseDto;
import com.example.BillingSystem.Service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/Customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/add")
    public CustomerResponseDto addCustomer(
            @Valid @RequestBody CustomerDto dto
    ){
        return customerService.addCustomer(dto);
    }

    @GetMapping("/{customer_id}")
    public CustomerResponseDto findCustomerById(
            @PathVariable("customer_id") Long id
    ){
        return customerService.findCustomerById(id);
    }

    @GetMapping("/{customer_phonenumber}")
    public CustomerResponseDto findCustomerByPhonenumber(
            @PathVariable("customer_phonenumber") String phoneNumber
    ){
        return customerService.findCustomerByPhonenumber(phoneNumber);
    }

    @GetMapping("/{customer_fullname}")
    public List<CustomerResponseDto> findCustomerByFullname(
            @PathVariable("customer_fullname") String fullname
    ){
        return customerService.findCustomerByFullname(fullname);
    }

    @GetMapping("/All")
    public List<CustomerResponseDto> findAllCustomers()
        {
            return customerService.findAllCustomers();
        }

                // this is for update
//    @PutMapping(".Customer/{customer_id}")
//    public ResponseEntity<CustomerResponseDto> updateCustomer(
//            @PathVariable("customer_id") Long id,
//            @Valid @RequestBody CustomerDto dto) {
//        CustomerResponseDto response = customerService.updateCustomer(id, dto);
//        if (response != null) {
//            return ResponseEntity.ok(response); // 200 OK
//        } else {
//            return ResponseEntity.notFound().build(); // 404 Not Found
//        }
//    }

    @DeleteMapping("/{customer_id}")
    public void delete (
            @PathVariable ("customer_id") Long id
    ){
        customerService.delete(id);
    }
}
