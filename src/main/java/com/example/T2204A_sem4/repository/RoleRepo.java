package com.example.T2204A_sem4.repository;

import com.example.T2204A_sem4.entity.Role;
import com.example.T2204A_sem4.entity.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface RoleRepo extends JpaRepository<Role,Long> {
    Optional<Role> findByName(ERole name);
    Optional<Role> findById(Long id);
     Set<Role> findByIdIn(Set<Long> id);
}
