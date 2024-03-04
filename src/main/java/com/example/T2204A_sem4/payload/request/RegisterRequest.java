package com.example.T2204A_sem4.payload.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String firstname;
    private String lastname;
    @NotBlank
    @Size(min = 3, max = 20)
    private String email;
    @NotBlank
    @Size(min = 3, max = 20)
    private String password;
    private Set<Long> role;
}
