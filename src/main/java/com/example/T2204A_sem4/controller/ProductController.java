package com.example.T2204A_sem4.controller;


import com.example.T2204A_sem4.entity.Product;
import com.example.T2204A_sem4.repository.ProductRepo;
import com.example.T2204A_sem4.service.IPML.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/products")
public class ProductController {

@Autowired
private ProductService productService;

@Autowired
private ProductRepo ppr;

    @GetMapping("")
    private List<Product> getAllBooks()
    {
        return productService.getAllProduct();
    }

    //creating a get mapping that retrieves the detail of a specific book
    @GetMapping("/{id}")
    private Product getProduct(@PathVariable("id") Long id)
    {
        return productService.getProductById(id);
    }
    @DeleteMapping("{id}")
    private void deleteProduct(@PathVariable("id") Long id)
    {
        productService.delete(id);
    }
    //creating post mapping that post the book detail in the database
    @PostMapping("/create")
    private Long saveBook(@RequestBody Product product)
    {
        productService.saveOrUpdate(product);
        return product.getId();
    }
    //creating put mapping that updates the book detail
    @PutMapping("/update")
    private Product update(@RequestBody Product product)
    {
        productService.saveOrUpdate(product);
        return product;
    }
    @GetMapping("/filter")
    private List<Product> filterBy(
            @RequestParam String name ,
            @RequestParam Integer minPrice ,
            @RequestParam Integer maxPrice
    ){
        return productService.filterBy(name,minPrice,maxPrice);
    }



}
