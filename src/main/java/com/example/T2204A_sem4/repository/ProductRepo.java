package com.example.T2204A_sem4.repository;

import com.example.T2204A_sem4.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepo extends CrudRepository<Product,Long> {

    @Query(
            "SELECT p from Product p "+
           "WHERE (:name is NULL OR p.name LIKE %:name OR p.description LIKE :name)"+
           "AND (:minPrice is NULL OR p.price >= :minPrice)"+
           "AND (:maxPrice is NULL OR p.price <= :maxPrice)"

    )
    List<Product> filterProduct(@Param("name") String name,@Param("minPrice") Integer minPrice,@Param("maxPrice") Integer maxPrice);
}
