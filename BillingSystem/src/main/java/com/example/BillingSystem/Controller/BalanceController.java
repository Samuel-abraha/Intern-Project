package com.example.BillingSystem.Controller;


import com.example.BillingSystem.Dto.BalanceDto;
import com.example.BillingSystem.Dto.BalanceinqueryDto;
import com.example.BillingSystem.Service.BalanceService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/balance")
public class BalanceController {

    private final BalanceService balanceService;

    public BalanceController(BalanceService balanceService) {
        this.balanceService = balanceService;
    }



    @PostMapping("/addBalance")
    public String addBalance(
             @RequestBody BalanceDto dto
    ){
        return balanceService.Depositebalance(dto);
    }

    @GetMapping("/{customer_id}")
    public String Banlanceinquery(
            @PathVariable("customer_id") Long id
    ){
        return balanceService.Balance(id);
    }



}
