package com.example.BillingSystem.Repository;



import com.example.BillingSystem.Entitys.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface InvoiceRepository extends JpaRepository<Invoice,Long> {

    Optional<Invoice> findByCustomer_Phonenumber(String phonenumber);
}
