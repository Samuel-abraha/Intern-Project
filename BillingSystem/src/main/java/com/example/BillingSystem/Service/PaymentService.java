package com.example.BillingSystem.Service;




import com.example.BillingSystem.Dto.PaymentDto;
import com.example.BillingSystem.Dto.PaymentResponseDto;
import com.example.BillingSystem.Entitys.Payment;
import com.example.BillingSystem.Mapper.PaymentMapper;
import com.example.BillingSystem.Repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class PaymentService {
    private  PaymentMapper paymentMapper;
    private PaymentDto dto;
    private PaymentRepository paymentRepository;
    private BalanceService balanceService;

    String remaining;
    LocalDateTime myObj = LocalDateTime.now();
    public PaymentService(PaymentMapper paymentMapper, PaymentRepository paymentRepository, BalanceService balanceService) {
        this.paymentMapper = paymentMapper;
        this.paymentRepository = paymentRepository;
        this.balanceService = balanceService;
    }



    public PaymentResponseDto receipt_for_payment(PaymentDto dto){
        this.dto=dto;
        String state=BalanceChecker();
        String message="failed";
        if(state.equals("200")){
            message="Payment completed";

            return paymentMapper.toPaymentResponseDto(pay_repo(),message,200);
//            return "payment completed successfuly"+"\n"+"Transaction Id:"+Transaction_Id()+"\n"+"remaing balance:"+remaining;
        }else{
           return paymentMapper.toPaymentResponseDto(pay_repo(),state,300);
//            return state;
        }
    }

private String BalanceChecker(){

    String state=balanceService.Banlanceinquery(dto);
    if(!Objects.equals(state, "200")){
        BigDecimal available_balance=new BigDecimal(state);
        BigDecimal tob_paidamount= dto.paid_amount();
        if( available_balance.intValue() < tob_paidamount.intValue() ){
            return "insufficient balance";
        }
        else{
            remaining=balanceService.Withdrawbalance(dto.id(),tob_paidamount,available_balance);
            Payment payment=pay_repo();
            var paymentt=paymentRepository.save(payment);
        }
    }
    return "200" ;
}


    private String Transaction_Id(){
         // Create a date object
        return myObj.toString().replaceAll("-","")+dto.id();
    }

    private Payment pay_repo(){
       Payment payment=new Payment();


        payment.setId(dto.id());
        payment.setPaymentDate(myObj);
        payment.setAmount(dto.paid_amount());
        payment.setTransaction_ID(Transaction_Id());

        return payment;
    }

}
