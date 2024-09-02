package com.example.BillingSystem.Repository;

import com.example.BillingSystem.Entitys.Admin;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository  extends JpaRepository <Admin,Long> {

    Optional<Admin> findByPhonenumber(String phonenumber);
    Optional<Admin> findByEmail(String email);
    Optional<Admin> findByUser_Username(String username);
}
