package com.example.BillingSystem.Mapper;

import com.example.BillingSystem.Dto.AdminDto;
import com.example.BillingSystem.Dto.AdminResponseDto;

import com.example.BillingSystem.Entitys.Admin;

import com.example.BillingSystem.Entitys.User;
import org.springframework.stereotype.Service;

@Service
public class AdminMapper {
    public Admin toAdmin(AdminDto dto){
        var admin = new Admin();
        admin.setFullname(dto.fullname());
        admin.setEmail(dto.email());
        admin.setPhonenumber(dto.phonenumber());

        var user = new User();
        user.setUsername(dto.userDto().username());
        user.setPassword(dto.userDto().password());
        user.setRole(User.Role.ADMIN);

        admin.setUser(user);


        return admin;
    }

    public AdminResponseDto toAdminResponseDto(Admin admin){

        return new AdminResponseDto(
                admin.getFullname(),
                admin.getEmail(),
                admin.getPhonenumber(),
                admin.getUser().getUsername(),
                admin.getUser().getPassword());
    }

}
