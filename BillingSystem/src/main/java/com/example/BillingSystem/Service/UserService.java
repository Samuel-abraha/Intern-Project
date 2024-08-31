package com.example.BillingSystem.Service;

import com.example.BillingSystem.Dto.UserDto;
import com.example.BillingSystem.Dto.UserResponseDto;
import com.example.BillingSystem.Entitys.User;
import com.example.BillingSystem.Mapper.UserMapper;
import com.example.BillingSystem.Repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public ResponseEntity<String> userLogin(UserDto dto) {
        // Fetch user by username
        User user = userRepository.findByUsername(dto.username());
        if (user == null) {
            return ResponseEntity.status(400).body("User not found");
        }

        // Validate credentials directly
        if (!dto.password().equals(user.getPassword())) {
            return ResponseEntity.status(400).body("Incorrect username or password");
        }

        // Check user role and return a response based on the role
        if (user.getRole() == User.Role.ADMIN) {
            return ResponseEntity.ok("Admin logged in successfully");
        } else if (user.getRole() == User.Role.CUSTOMER) {
            return ResponseEntity.ok("Customer logged in successfully");
        }

        return ResponseEntity.status(403).body("Access denied");
    }

    public ResponseEntity<String> addUser(UserDto dto) {
        // Convert UserDto to User entity
        User user = userMapper.toUser(dto);
        userRepository.save(user);

        return ResponseEntity.ok("User added successfully");
    }

    public ResponseEntity<UserResponseDto> getAdminProfileByUsername(String username) {
        // Fetch user by username
        User user = userRepository.findByUsername(username);

        // Check if user exists and has ADMIN role
        if (user != null && user.getRole() == User.Role.ADMIN) {
            // Convert User entity to UserResponseDto
            UserResponseDto userResponseDto = userMapper.toUserResponseDto(user);
            return ResponseEntity.ok(userResponseDto);
        }

        // Return Not Found if user doesn't exist or is not an admin
        return ResponseEntity.notFound().build();
    }
}
