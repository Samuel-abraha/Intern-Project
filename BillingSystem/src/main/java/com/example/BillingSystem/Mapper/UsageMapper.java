package com.example.BillingSystem.Mapper;

import com.example.BillingSystem.Entitys.Customer;
import com.example.BillingSystem.Dto.UsageDto;
import com.example.BillingSystem.Dto.UsageResponseDto;
import com.example.BillingSystem.Entitys.BillingService;
import com.example.BillingSystem.Entitys.Usage;
import org.springframework.stereotype.Service;

@Service
public class UsageMapper {

    public Usage toUsage(UsageDto dto, Customer customer, BillingService billingservice) {
        Usage usage = new Usage();

        usage.setUsageDate(dto.usageDate());
        usage.setUsageAmount(dto.usageAmount());
        usage.setBillingPeriod(dto.billingPeriod());
        usage.setCustomer(customer);
        usage.setBillingService(billingservice);

        return usage;
    }

    public UsageResponseDto toUsageResponseDto(Usage usage) {
        // Map the Usage entity to a UsageResponseDto
        return new UsageResponseDto(

                usage.getUsageAmount(),
                usage.getBillingPeriod(),
                usage.getUsageDate(),
                usage.getCustomer().getFullname(),
                usage.getCustomer().getPhonenumber(),
                usage.getBillingService().getServiceName()

        );
    }
}
