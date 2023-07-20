package com.example.projectOneJDBC.service;

import com.example.projectOneJDBC.dto.Product;
import com.example.projectOneJDBC.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;
    public void saveOrUpdate(Product product) {
        productRepo.save(product);
    }
    public Product getProductById(int id){
        return productRepo.findById(id);
    }
    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }
    public void deleteProduct(Product product) {
        productRepo.delete(product);
    }
    //more methods for business logic

}
