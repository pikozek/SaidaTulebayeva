package org.example;

import org.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository pR) {
        this.productRepository = pR;
    }

    // 1) Method to list products in descending order
    // 2) Method to return the most expensive item in the product list
    // 3) Method to return the biggest order (in terms of expense)
    // 4) The most purchased product
    // 5) Average order price for all users
}
