package com.example.BillingSystem.Controller;


import com.example.BillingSystem.Dto.PaymentDto;
import com.example.BillingSystem.Dto.PaymentResponseDto;
import com.example.BillingSystem.Service.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }


    @PostMapping("/paymentservice")
    public PaymentResponseDto paymentservice(
             @RequestBody PaymentDto dto
    ){
        return paymentService.receipt_for_payment(dto);
    }



}
