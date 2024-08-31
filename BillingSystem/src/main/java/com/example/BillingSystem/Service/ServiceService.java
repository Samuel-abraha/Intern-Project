package com.example.BillingSystem.Service;

import com.example.BillingSystem.Dto.ServiceDto;
import com.example.BillingSystem.Dto.ServiceResponseDto;
import com.example.BillingSystem.Mapper.ServiceMapper;
import com.example.BillingSystem.Repository.ServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceService {

    private final ServiceRepository serviceRepository;
    private final ServiceMapper serviceMapper;

    public ServiceService(ServiceRepository serviceRepository, ServiceMapper serviceMapper) {
        this.serviceRepository = serviceRepository;
        this.serviceMapper = serviceMapper;
    }


    public ServiceResponseDto addService(ServiceDto dto){
        var service = serviceMapper.toService(dto);
        var savedService = serviceRepository.save(service);

        return serviceMapper.toServiceResponseDto(savedService);
    }

    public List<ServiceResponseDto> findAllServices(){
        return serviceRepository.findAll()
                .stream()
                .map(serviceMapper::toServiceResponseDto)
                .collect(Collectors.toList());
    }

    public ServiceResponseDto findServiceByserviceName(String serviceName){       //fetching Service by name
        return serviceRepository.findAllByServiceNameContainingIgnoreCase(serviceName)
                .map(serviceMapper::toServiceResponseDto)
                .orElse(null);
        //              .orElseThrow(() -> new RuntimeException("Service not found with Service name: " + serviceName));
    }

    public void delete (Long id){
        serviceRepository.deleteById(id);
    }
}
