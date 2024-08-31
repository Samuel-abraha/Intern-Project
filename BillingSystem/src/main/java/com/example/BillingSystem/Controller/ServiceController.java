package com.example.BillingSystem.Controller;

import com.example.BillingSystem.Dto.ServiceDto;
import com.example.BillingSystem.Dto.ServiceResponseDto;
import com.example.BillingSystem.Service.ServiceService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/BillingService")
public class ServiceController {

    private final ServiceService serviceService;

    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @PostMapping("/add")
    public ServiceResponseDto addService(
            @Valid @RequestBody ServiceDto dto
    ){
        return serviceService.addService(dto);
    }



    @GetMapping("/{service_servicename}")
    public ServiceResponseDto findServiceByserviceName(
            @PathVariable("service_servicename") String serviceName
    ){
        return serviceService.findServiceByserviceName(serviceName);
    }

    @DeleteMapping("/{service_id}")
    public void delete (
            @PathVariable("service_id") Long id
    ){
        serviceService.delete(id);
    }
}
