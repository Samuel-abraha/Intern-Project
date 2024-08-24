package com.example.BillingSystem.Repository;

import com.example.BillingSystem.Entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
