package com.example.BillingSystem.Service;


import com.example.BillingSystem.Dto.CustomerDto;
import com.example.BillingSystem.Dto.CustomerResponseDto;
import com.example.BillingSystem.Mapper.CustomerMapper;
import com.example.BillingSystem.Repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    // we don't use @Autowired because it only one constructor
    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public CustomerResponseDto addCustomer(CustomerDto dto) {          //save customer
        var customer = customerMapper.toCustomer(dto);
        var savedStudent = customerRepository.save(customer);

        return customerMapper.toCustomerResponseDto(savedStudent);
    }

    public CustomerResponseDto findCustomerById(Long id){           // fetching customer by id
        return customerRepository.findById(id)
                .map(customerMapper::toCustomerResponseDto)
                .orElse(null);
//              .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
    }

    public CustomerResponseDto findCustomerByPhonenumber(String phoneNumber){
        return customerRepository.findByPhonenumber(phoneNumber)
                .map(customerMapper::toCustomerResponseDto)
                .orElse(null);
        //              .orElseThrow(() -> new RuntimeException("Customer not found with phonenumber: " + phonenumber));
    }


    public List<CustomerResponseDto> findCustomerByFullname(String fullname){       //fetching customer by fullname
        return customerRepository.findAllByFullnameContainingIgnoreCase(fullname)
                .stream()
                .map(customerMapper::toCustomerResponseDto)
                .collect(Collectors.toList());
    }

    public List<CustomerResponseDto> findAllCustomers()     //fetching all customers
    {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::toCustomerResponseDto)
                .collect(Collectors.toList());
    }

                        //    this for update
//    public CustomerResponseDto updateCustomer(Long id, CustomerDto dto) {
//        return customerRepository.findById(id).map(customer -> {
//            // Update fields as needed
//            customer.setFullname(dto.fullname()); // if this doesn't work , make fullname to getfullname and all for the other too
//            customer.setEmail(dto.email());
//            customer.setPhonenumber(dto.phonenumber());
//            customer.setAddress(dto.address());
//            // Optionally, update user details if present
//            if (dto.userDto() != null) {
//                customer.setUser(dto.userDto()); // Assuming User is a part of dto
//            }
//            // Save the updated customer
//            var updatedCustomer = customerRepository.save(customer);
//            return customerMapper.toCustomerResponseDto(updatedCustomer);
//        }).orElseThrow(() -> new RuntimeException("Customer not found with id " + id));
//    }


    public void delete (Long id){
         customerRepository.deleteById(id);
    }


}
