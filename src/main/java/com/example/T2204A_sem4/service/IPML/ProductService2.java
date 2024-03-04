package com.example.T2204A_sem4.service.IPML;

import com.example.T2204A_sem4.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService2 {

    @Autowired
    private ProductRepo productRepo;

//    like
//    public ProductService2(ProductRepo productRepo){
//        this.productRepo = productRepo;
//    }

}
