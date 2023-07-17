package org.example.repository;

import lombok.RequiredArgsConstructor;
import org.example.dto.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProductRepo implements ProductRepository {

    private final JdbcTemplate jdbcTemplate;
    private final String tableName;

    @Override
    public Product save(Product product) {
        String sql = "INSERT INTO " + tableName + " (id, name, price, purchasecount) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, product.getId(), product.getName(), product.getPrice(), product.getPurchaseCount());
        return product;
    }

    @Override
    public void delete(Product product) {
        String sql = "DELETE FROM " + tableName + " WHERE id = ?";
        jdbcTemplate.update(sql, product.getId());
    }

    @Override
    public void incrementPurchaseCount(Product product) {
        int currentCount = product.getPurchaseCount();
        product.setPurchaseCount(currentCount + 1);
        save(product);
    }
}
