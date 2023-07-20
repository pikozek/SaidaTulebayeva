package com.example.projectOneJDBC.mapper;

import com.example.projectOneJDBC.dto.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException{
        Product product = Product.builder()
                .id(rs.getLong("id"))
                .productName(rs.getString("name"))
                .price(rs.getInt("price"))
                .build();
        return product;
    }
}
