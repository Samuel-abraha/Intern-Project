package com.example.BillingSystem.Repository;


import com.example.BillingSystem.Entitys.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Long> {


}
