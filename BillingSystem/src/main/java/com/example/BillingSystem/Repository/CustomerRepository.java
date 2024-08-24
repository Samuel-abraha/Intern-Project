package com.example.BillingSystem.Repository;

import com.example.BillingSystem.Entitys.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findAllByFullnameContainingIgnoreCase(String fullname);

    Optional<Customer> findByPhonenumber(String phonenumber);
}
