package org.example.repository;
import org.example.dto.Product;
import java.util.List;

public interface ProductRepository {
    Product save(Product product);

    Product findById(Long id);

    List<Product> findAll();

    void delete(Product product);
}
