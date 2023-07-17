package org.example.repository;

import org.example.dto.Product;

public interface ProductRepository {
    Product save(Product product);

    void delete(Product product);

    void incrementPurchaseCount(Product product);
}
