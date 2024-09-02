package com.example.BillingSystem.Service;

import com.example.BillingSystem.Entitys.Customer;
import com.example.BillingSystem.Repository.CustomerRepository;
import com.example.BillingSystem.Dto.UsageDto;
import com.example.BillingSystem.Dto.UsageResponseDto;
import com.example.BillingSystem.Mapper.UsageMapper;
import com.example.BillingSystem.Repository.UsageRepository;
import com.example.BillingSystem.Repository.ServiceRepository;

import com.example.BillingSystem.Entitys.Usage;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.stream.Collectors;

@Service
public class UsageService {

    private final UsageRepository usageRepository;
    private final CustomerRepository customerRepository;
    private final ServiceRepository serviceRepository;
    private final UsageMapper usageMapper;


    public UsageService(
            UsageRepository usageRepository,
            CustomerRepository customerRepository,
            ServiceRepository serviceRepository,
            UsageMapper usageMapper
    ) {
        this.usageRepository = usageRepository;
        this.customerRepository = customerRepository;
        this.serviceRepository = serviceRepository;
        this.usageMapper = usageMapper;

    }

    public UsageResponseDto addUsage(UsageDto dto) {
        // Fetch customer by phone number
        Customer customer = customerRepository.findByPhonenumber(dto.customerPhoneNumber())
                .orElseThrow(() -> new RuntimeException("Customer not found with phone number " + dto.customerPhoneNumber()));

        // Fetch service by service name
        BillingService billingService = serviceRepository.findAllByServiceNameContainingIgnoreCase(dto.serviceName())
                .orElseThrow(() -> new RuntimeException("Service not found with service name " + dto.serviceName()));

        // Create and save the Usage entity
        Usage usage = usageMapper.toUsage(dto, customer, billingService);
        Usage savedUsage = usageRepository.save(usage);

        // Map the saved entity to a response DTO and return it
        return usageMapper.toUsageResponseDto(savedUsage);
    }

    public List<UsageResponseDto> getUsagesByCustomerPhoneNumber(String phoneNumber) {
        List<Usage> usages = usageRepository.findByCustomer_Phonenumber(phoneNumber);
        return usages
                .stream()
                .map(usageMapper::toUsageResponseDto)
                .collect(Collectors.toList());
    }
}
