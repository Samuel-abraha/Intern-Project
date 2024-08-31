package com.example.BillingSystem.Mapper;

import com.example.BillingSystem.Dto.CustomerDto;
import com.example.BillingSystem.Dto.CustomerResponseDto;
import com.example.BillingSystem.Dto.UserDto;
import com.example.BillingSystem.Dto.UserResponseDto;
import com.example.BillingSystem.Entitys.Customer;
import com.example.BillingSystem.Entitys.User;
import org.springframework.stereotype.Service;



@Service
public class UserMapper {
    public User toUser(UserDto dto){
        var user = new User();
        user.setUsername(dto.username());
        user.setPassword(dto.password());
        user.setRole(User.Role.ADMIN);

        return user;
    }

    public UserResponseDto toUserResponseDto(User user) {
        return new UserResponseDto(
                user.getUsername(),
                user.getPassword()
        );
    }
}
