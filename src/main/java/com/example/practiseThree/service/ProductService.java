package com.example.practiseThree.service;

import com.example.practiseThree.dto.Product;
import com.example.practiseThree.dto.User;
import com.example.practiseThree.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }
    public List<Product> saveProducts(List<Product> products){
        return productRepository.saveAll(products);
    }
    public Product findProductById(int id){
        return productRepository.findById(id).orElse(null);
    }
    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    @Transactional
    public Product updateProduct(Product product){
        Optional<Product> optionalProduct=productRepository.findById(product.getId());
        if(optionalProduct.isPresent()){
            Product oldProduct = optionalProduct.get();
            oldProduct.setProductName(product.getProductName());
            oldProduct.setPrice(product.getPrice());
            return productRepository.save(oldProduct);
        }
        return new Product();
    }
    public Product theMostExpensiveProduct() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .max(Comparator.comparingDouble(Product::getPrice))
                .orElse(null);
    }
    public String delete(int id){
        productRepository.deleteById(id);
        return "Product got deleted";
    }
}
