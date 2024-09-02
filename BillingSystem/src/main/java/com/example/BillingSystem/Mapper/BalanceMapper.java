package com.example.BillingSystem.Mapper;

import com.example.BillingSystem.Dto.BalanceDto;
import com.example.BillingSystem.Entitys.Balance;
import org.springframework.stereotype.Service;

@Service
public class BalanceMapper {

    public Balance toBalance(BalanceDto dto){
        var balance = new Balance();
        balance.setCurrent_balance(dto.Deposite_Amount());


        return balance;
    }

 }
