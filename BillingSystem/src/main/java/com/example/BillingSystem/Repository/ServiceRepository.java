package com.example.BillingSystem.Repository;


import com.example.BillingSystem.Service.BillingService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ServiceRepository extends JpaRepository<BillingService,Long> {

    Optional<BillingService> findAllByServiceNameContainingIgnoreCase(String serviceName);
}
