package org.example;

import org.example.dto.Order;
import org.example.dto.Product;
import org.example.dto.User;
import org.example.repository.ProductRepository;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository pR){
        this.productRepository = pR;
    }

    //Method to list products in descending order
    public List<Product> filterAndSortByPrice(){
        return productRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .collect(Collectors.toList());
    }

}
