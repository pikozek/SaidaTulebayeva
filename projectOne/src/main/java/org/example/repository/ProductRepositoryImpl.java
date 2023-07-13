package org.example.repository;

import lombok.RequiredArgsConstructor;
import org.example.dto.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository{
    private final List<Product> products = new ArrayList<>();

    @Override
    public Product save(Product product) {
        products.add(product);
        return product;
    }

    @Override
    public Product findById(Long id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products);
    }

    @Override
    public void delete(Product product) {
        products.remove(product);
    }
}
