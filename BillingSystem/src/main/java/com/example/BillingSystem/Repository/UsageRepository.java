package com.example.BillingSystem.Repository;


import com.example.BillingSystem.Entitys.Customer;
import com.example.BillingSystem.Entitys.Usage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsageRepository extends JpaRepository<Usage,Long> {
    // Custom query method to find usages by customer's phone number
    List<Usage> findByCustomer_Phonenumber(String phonenumber);

    List<Usage> findAllByCustomer(Customer customer);
}
