package com.example.projectOneJDBC.repository;

import com.example.projectOneJDBC.dto.Order;
import com.example.projectOneJDBC.dto.Product;
import com.example.projectOneJDBC.mapper.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.Period;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
@Transactional
public class ProductRepo {
    private final JdbcTemplate jdbcTemplate;
    private final ProductRowMapper productRowMapper;
    @Autowired
    public ProductRepo(JdbcTemplate jdbcTemplate, ProductRowMapper productRowMapper){
        this.jdbcTemplate = jdbcTemplate;
        this.productRowMapper = productRowMapper;
    }
    public Product save(Product product){
        String sql = "INSERT INTO products(name, price) VALUES(?, ?)";
        jdbcTemplate.update(sql, product.getProductName(), product.getPrice());
        return product;
    }
    public void delete(Product product){
        String sql = "DELETE FROM products WHERE id = ?";
        jdbcTemplate.update(sql, product.getId().intValue());
    }
    public Product findById(int id) {
        String sql = "SELECT * FROM products WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, productRowMapper, id);
    }
    public List<Product> findAll(){
        String sql = "SELECT * FROM products";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        return rows.stream()
                .map(this::mapToProduct)
                .collect(Collectors.toList());
    }
    public Product mapToProduct(Map<String, Object> row) {
        Product product = Product.builder()
                .id(((Number)row.get("id")).longValue())
                .price((int)row.get("price"))
                .productName((String)row.get("name"))
                .build();
        return product;
    }
}
