package com.example.BillingSystem.Controller;

import com.example.BillingSystem.Dto.UsageDto;
import com.example.BillingSystem.Dto.UsageResponseDto;
import com.example.BillingSystem.Service.UsageService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usage")
public class UsageController {

    private final UsageService usageService;

    public UsageController(UsageService usageService) {
        this.usageService = usageService;
    }

    @PostMapping("/add")
    public UsageResponseDto addUsage(
            @Valid @RequestBody UsageDto dto){
        return usageService.addUsage(dto);
    }

    @GetMapping("/{customer_phonenumber}")
    public List<UsageResponseDto> findCustomerById(
            @PathVariable("customer_phonenumber") String phonenumber
    ){
        return usageService.getUsagesByCustomerPhoneNumber(phonenumber);
    }
}
