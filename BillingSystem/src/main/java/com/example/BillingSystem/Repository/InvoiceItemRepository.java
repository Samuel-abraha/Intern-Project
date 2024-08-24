package com.example.BillingSystem.Repository;


import com.example.BillingSystem.Entitys.InvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InvoiceItemRepository extends JpaRepository<InvoiceItem,Long> {

    Optional<InvoiceItem> findByCustomer_Phonenumber(String phonenumber);
}
