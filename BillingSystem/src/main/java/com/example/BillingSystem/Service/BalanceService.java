package com.example.BillingSystem.Service;



import com.example.BillingSystem.Dto.BalanceDto;
import com.example.BillingSystem.Dto.BalanceinqueryDto;
import com.example.BillingSystem.Dto.CustomerResponseDto;
import com.example.BillingSystem.Dto.PaymentDto;
import com.example.BillingSystem.Entitys.Balance;
import com.example.BillingSystem.Mapper.BalanceMapper;
import com.example.BillingSystem.Mapper.CustomerMapper;
import com.example.BillingSystem.Repository.BalanceRepository;
import com.example.BillingSystem.Repository.UserRepository;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class BalanceService {
    private final CustomerService customerService;
    private final BalanceRepository balanceRepository;
    private final BalanceMapper balanceMapper;
    private  Balance balance;

    public BalanceService(BalanceRepository balanceRepository, CustomerMapper customerMapper, UserRepository userRepository, CustomerService customerService, BalanceMapper balanceMapper) {
        this.balanceRepository = balanceRepository;
        this.customerService = customerService;
        this.balanceMapper = balanceMapper;
    }

    public String Banlanceinquery (PaymentDto dto){
        Balance balance=balanceRepository.findByid(dto.id());
        if(balance == null){
            return null;
        }else{
           return balance.getCurrent_balance().toString();
        }
    }
    public String Balance (long id){
        Balance balance=balanceRepository.findByid(id);
        if(balance == null){
            return null;
        }else{
            return balance.getCurrent_balance().toString();
        }
    }

    public String Depositebalance (BalanceDto dto){
        CustomerResponseDto cus=customerService.findCustomerById(dto.id());
        if(cus != null) {
            balance= balanceRepository.findById(dto.id())
                    .orElse(null);

            BigDecimal newBalanceAmount= balance.getCurrent_balance().add(dto.Deposite_Amount());
            balance.setCurrent_balance(newBalanceAmount);
            var savedStudent = balanceRepository.save(balance);
        }else{
            return "unknown customer";
        }

        return "pls check it manually in the database";
    }
    public String Withdrawbalance (long id,BigDecimal paid_amount,BigDecimal available_balance){
         balance= balanceRepository.findById(id)
                 .orElse(null);


        // Update the balance
        BigDecimal newBalanceAmount=(available_balance.subtract(paid_amount));
        balance.setCurrent_balance(newBalanceAmount);

        // Save the updated balance back to the repository
         balanceRepository.save(balance);
        balance= balanceRepository.findById(id)
                .orElse(null);

            return balance.getCurrent_balance().toString();
    }


}
