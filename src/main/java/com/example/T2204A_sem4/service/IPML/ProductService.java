package com.example.T2204A_sem4.service.IPML;

import com.example.T2204A_sem4.entity.Product;
import com.example.T2204A_sem4.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
@Configuration
public class ProductService {


    @Autowired
    ProductRepo productRepo;
    //getting all books record by using the method findaAll() of CrudRepository
    public List<Product> getAllProduct()
    {
        List<Product> products = new ArrayList<Product>();
        productRepo.findAll().forEach(books1 -> products.add(books1));
        return products;
    }


    public Product getProductById(Long id)
    {
        return productRepo.findById(id).get();
    }

    public Product saveOrUpdate(Product product)
    {
//       return productRepo.findById(product.getId()).map(p->{
//            p.setId(product.getId());
//            p.setName(product.getName());
//            p.setPrice(product.getPrice());
//            p.setDescription(p.getDescription());
//            p.setThumbnail(p.getThumbnail());
//            return productRepo.save(product);
//        }).orElseGet(()->{
//
//       });
       return  productRepo.save(product);
    }
    public void delete(Long id)
    {
        productRepo.deleteById(id);
    }
    public void update(Product product, Long id)
    {
        productRepo.save(product);
    }

    public List<Product> filterBy(String name,Integer minPrice,Integer maxPrice){
        return productRepo.filterProduct(name,minPrice,maxPrice);
    }
}
