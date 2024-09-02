package com.example.BillingSystem.Mapper;

import com.example.BillingSystem.Dto.CustomerDto;
import com.example.BillingSystem.Dto.CustomerResponseDto;
import com.example.BillingSystem.Dto.PaymentResponseDto;
import com.example.BillingSystem.Entitys.Customer;
import com.example.BillingSystem.Entitys.Payment;
import com.example.BillingSystem.Entitys.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentMapper {

    public PaymentResponseDto toPaymentResponseDto(Payment payment,String message, int state) {
        if(state == 200) {
            return new PaymentResponseDto(
                    message,
                    payment.getTransaction_ID()
            );
        }else{
            return new PaymentResponseDto(
                    message,null
            );
        }
    }



}