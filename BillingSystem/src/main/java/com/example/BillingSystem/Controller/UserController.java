package com.example.BillingSystem.Controller;

import com.example.BillingSystem.Dto.UserDto;
import com.example.BillingSystem.Dto.UserResponseDto;
import com.example.BillingSystem.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/User")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/userLogin")
    public ResponseEntity<String> userLogin(
            @RequestBody UserDto dto
    ){
        return userService.userLogin(dto);
    }

    // for adding admin
    @PostMapping("/Add")
    public ResponseEntity<String> addUser(@RequestBody UserDto dto){
        return userService.addUser(dto);
    }



}
