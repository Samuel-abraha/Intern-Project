package com.example.BillingSystem.Service;

import com.example.BillingSystem.Authentication.LoginAutenticator;
import com.example.BillingSystem.Dto.UserDto;
import com.example.BillingSystem.Entitys.User;
import com.example.BillingSystem.Mapper.CustomerMapper;
import com.example.BillingSystem.Repository.CustomerRepository;
import com.example.BillingSystem.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final UserRepository userRepository;

    public UserService(CustomerRepository customerRepository, CustomerMapper customerMapper, UserRepository userRepository) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
        this.userRepository = userRepository;
    }

    public  String userLogin( UserDto dto) {
        String status=null;
        User user = userRepository.findByUsername(dto.username());
        if(user != null){
            LoginAutenticator loginauth= new LoginAutenticator(dto,user.getUsername(),user.getPassword());
            status=loginauth.isempty();

            if(Objects.equals(status, "200"))
                return "successfully logined";
        }
        return status;

    }

}
