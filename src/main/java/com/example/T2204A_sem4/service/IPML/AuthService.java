package com.example.T2204A_sem4.service.IPML;

import com.example.T2204A_sem4.config.JwtService;
import com.example.T2204A_sem4.entity.Role;
import com.example.T2204A_sem4.entity.User;
import com.example.T2204A_sem4.entity.enums.ERole;
import com.example.T2204A_sem4.payload.request.LoginRequest;
import com.example.T2204A_sem4.payload.request.RegisterRequest;
import com.example.T2204A_sem4.payload.response.AuthResponse;
import com.example.T2204A_sem4.payload.response.MessageResponse;
import com.example.T2204A_sem4.repository.RoleRepo;
import com.example.T2204A_sem4.repository.UserRepo;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepo userRepository;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public ResponseEntity<?> register (RegisterRequest request){

        if(userRepository.existsByEmail(request.getEmail())){
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
        }
        Set<Long> rolesReq = request.getRole();
        Set<Role> roles = roleRepo.findByIdIn(rolesReq);
        System.out.println(roles.size());
//        rolesReq.forEach(r ->{
//            Optional<Role> findRole = roleRepo.findById(r.longValue());
////            ifPresent: nếu có 1 giá trị thì thực hiện còn không thì ko làm j cả
//            findRole.ifPresent(roles::add);
//        });
        if(roles.isEmpty()){
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Role Not found!"));
        }
                var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(roles)
                .build();
        var saveUser = userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);


        var resp = new AuthResponse().builder().token(jwtToken).build();
        return ResponseEntity.ok(resp);
    }

    public ResponseEntity<?> login (LoginRequest request){
//
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        var user = userRepository.findByEmail(request.getUsername()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);

        var resp = new AuthResponse().builder().token(jwtToken).build();
        return ResponseEntity.ok(resp);
    }

}
