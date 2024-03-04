package com.example.T2204A_sem4.entity.enums;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public enum ERole {
    ROLE_USER("user"),
    ROLE_MODERATOR("moderator"),
    ROLE_MANAGER("manager"),
    ROLE_ADMIN("admin");

    @Getter
    private final String role;

}
