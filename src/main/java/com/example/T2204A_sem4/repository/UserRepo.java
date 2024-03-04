package com.example.T2204A_sem4.repository;

import com.example.T2204A_sem4.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {

    boolean existsByEmail(String email);

    boolean existsById(Long id);

    @Override
    Optional<User> findById(Long id);

    Optional<User> findByEmail(String email);
}
