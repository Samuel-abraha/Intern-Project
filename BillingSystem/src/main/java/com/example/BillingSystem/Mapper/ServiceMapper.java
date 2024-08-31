package com.example.BillingSystem.Mapper;

import com.example.BillingSystem.Dto.ServiceDto;
import com.example.BillingSystem.Dto.ServiceResponseDto;
import com.example.BillingSystem.Entitys.BillingService;
import org.springframework.stereotype.Service;


@Service
public class ServiceMapper {

    public BillingService toService(ServiceDto dto) {

        var service = new BillingService();

        service.setServiceName(dto.serviceName());
        service.setUnitPrice(dto.unitPrice());
        service.setUnitOfMeasure(dto.unitOfMeasure());

        return service;
    }

    public ServiceResponseDto toServiceResponseDto(BillingService service) {

        return new ServiceResponseDto(
                service.getServiceName(),
                service.getUnitPrice(),
                service.getUnitOfMeasure()
        );
    }
}
