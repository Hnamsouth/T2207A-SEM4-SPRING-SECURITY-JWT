package com.example.T2204A_sem4.repository;

import com.example.T2204A_sem4.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepo extends JpaRepository<Category,Long> {
    List<Category> findAllByIdAndNameAndSlugAndStatus(Long id, String name, String slug, Boolean status);
    List<Category> findAllByIdOrNameOrSlugOrStatus(Long id, String name, String slug, Boolean status);

}
