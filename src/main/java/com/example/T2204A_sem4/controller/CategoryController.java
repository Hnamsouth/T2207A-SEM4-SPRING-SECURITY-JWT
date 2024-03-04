package com.example.T2204A_sem4.controller;


import com.example.T2204A_sem4.entity.Category;
import com.example.T2204A_sem4.service.IPML.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category"  )
@RequiredArgsConstructor
public class CategoryController implements  IBaseController<Category> {

    private final CategoryService categoryService;

    @Override
    @GetMapping
    public List<Category> get() {
        return categoryService.getAll();
    }

    @Override
    @PostMapping("/create")
    public Category create(@RequestBody Category category) {
        return categoryService.create(category);
    }

    @Override
    @PutMapping("/update")
    public Category update(@RequestBody Category category) {
        return categoryService.update(category);
    }

    @Override
    @PutMapping("/update2")
    public Category update(Category category, Long e) {
        return null;
    }

    @Override
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return categoryService.delete(id);
    }

    @Override
    @GetMapping("/{id}")
    public <Long> Category find(@PathVariable Long id) {
        return categoryService.find(id);
    }

    @Override
    @GetMapping("/search")
    public List<Category> search(@RequestParam String search) {
        return categoryService.search(search);
    }

    @GetMapping("/search-multiple")
    public List<Category> searchMultiple(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String slug,
            @RequestParam(required = false) Boolean status) {
        return categoryService.searchMultiple(id,name,slug,status);
    }
}
