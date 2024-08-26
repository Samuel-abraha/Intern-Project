package com.example.BillingSystem.Mapper;

import com.example.BillingSystem.Entitys.Customer;
import com.example.BillingSystem.Dto.CustomerDto;
import com.example.BillingSystem.Dto.CustomerResponseDto;
import com.example.BillingSystem.Entitys.User;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {

    public Customer toCustomer(CustomerDto dto){
        var customer = new Customer();
        customer.setFullname(dto.fullname());
        customer.setEmail(dto.email());
        customer.setPhonenumber(dto.phonenumber());

        var user = new User();
        user.setUsername(dto.userDto().username());
        user.setPassword(dto.userDto().password());

        customer.setUser(user);


        return customer;
    }

    public CustomerResponseDto toCustomerResponseDto(Customer customer){

        return new CustomerResponseDto(
                customer.getFullname(),
                customer.getEmail(),
                customer.getPhonenumber(),
                customer.getUser().getUsername());
    }




}