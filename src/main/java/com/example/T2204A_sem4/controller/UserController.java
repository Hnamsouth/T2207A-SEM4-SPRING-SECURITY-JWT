package com.example.T2204A_sem4.controller;


import com.example.T2204A_sem4.entity.Role;
import com.example.T2204A_sem4.entity.User;
import com.example.T2204A_sem4.entity.enums.ERole;
import com.example.T2204A_sem4.payload.request.UserRequest;
import com.example.T2204A_sem4.repository.RoleRepo;
import com.example.T2204A_sem4.repository.UserRepo;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor

public class UserController {
    private final Set<ERole> Eroles;
    private  final RoleRepo roleRepo;
    private  final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/test-authority")
    @PreAuthorize("hasAuthority('admin:read')")
    public ResponseEntity<?> testAuth (){
        return ResponseEntity.ok(userRepo.findAll());
    }

    @PutMapping("/edit-user")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<?> editUser(@Valid @RequestBody UserRequest request){
        User u =  userRepo.findById(request.getId()).orElseThrow();

        Set<Role> roles = roleRepo.findByIdIn(request.getRole());
        var user = User.builder()
                        .id(request.getId())
                        .email(request.getEmail())
                        .firstname(request.getFirstname())
                        .lastname(request.getLastname())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .roles(roles)
                        .build();
        userRepo.save(user);
        return ResponseEntity.ok(user);
    }

}
