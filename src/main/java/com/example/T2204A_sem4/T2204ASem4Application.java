package com.example.T2204A_sem4;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")

public class T2204ASem4Application {


	public static void main(String[] args) {


		SpringApplication.run(T2204ASem4Application.class, args);
	}
}
