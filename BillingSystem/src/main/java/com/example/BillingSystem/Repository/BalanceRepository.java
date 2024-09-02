package com.example.BillingSystem.Repository;


import com.example.BillingSystem.Entitys.Balance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceRepository extends JpaRepository<Balance,Long> {

    Balance findByid(Long id);
}
