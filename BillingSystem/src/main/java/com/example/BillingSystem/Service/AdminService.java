package com.example.BillingSystem.Service;

import com.example.BillingSystem.Dto.AdminDto;
import com.example.BillingSystem.Dto.AdminResponseDto;
import com.example.BillingSystem.Entitys.Admin;
import com.example.BillingSystem.Entitys.User;
import com.example.BillingSystem.Mapper.AdminMapper;
import com.example.BillingSystem.Repository.AdminRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    private final AdminRepository adminRepository;
    private final AdminMapper adminMapper;

    public AdminService(AdminRepository adminRepository, AdminMapper adminMapper) {
        this.adminRepository = adminRepository;
        this.adminMapper = adminMapper;
    }

    public ResponseEntity<String> addAdmin(AdminDto dto) {
        // Check if the customer already exists by phone number or email or username
        if (adminRepository.findByPhonenumber(dto.phonenumber()).isPresent()) {
            return ResponseEntity.status(400).body("Phone number already exists");
        } else if (adminRepository.findByEmail(dto.email()).isPresent()) {
            return ResponseEntity.status(400).body("Email already exists");
        } else if (adminRepository.findByUser_Username(dto.userDto().username()).isPresent()) {
            return ResponseEntity.status(400).body("Username already exists");
        }

        // Save the new customer
        var admin = adminMapper.toAdmin(dto);
        adminRepository.save(admin);

        return ResponseEntity.ok("Successfully Registered");
    }

    public ResponseEntity<AdminResponseDto> getAdminProfileByUsername(String username) {
        // Fetch user by username
        Optional<Admin> admin = adminRepository.findByUser_Username(username);

        // Check if user exists and has ADMIN role
        if (admin.isPresent() && admin.get().getUser().getRole() == User.Role.ADMIN) {
            // Convert User entity to UserResponseDto
            AdminResponseDto adminResponseDto = adminMapper.toAdminResponseDto(admin.orElse(null));
            return ResponseEntity.ok(adminResponseDto);
        }

        // Return Not Found if user doesn't exist or is not an admin
        return ResponseEntity.notFound().build();
    }
}
