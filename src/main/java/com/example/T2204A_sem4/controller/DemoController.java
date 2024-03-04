package com.example.T2204A_sem4.controller;


import com.example.T2204A_sem4.entity.enums.ERole;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/demo1")
public class DemoController {

    @Getter
    public final ERole[] eroles = ERole.values();

    @GetMapping
    public void demo1(){
        Arrays.stream(eroles).forEach(er -> System.out.println(er.getRole()));
    }
}
