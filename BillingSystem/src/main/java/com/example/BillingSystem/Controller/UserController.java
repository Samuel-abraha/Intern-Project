package com.example.BillingSystem.Controller;

import com.example.BillingSystem.Dto.UserDto;
import com.example.BillingSystem.Service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/userLogin")
    public String userLogin(
            @RequestBody UserDto dto
    ){
        return userService.userLogin(dto);
    }
}
