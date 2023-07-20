package com.example.projectOneJDBC.mapper;

import com.example.projectOneJDBC.dto.Order;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRowMapper implements RowMapper<Order> {
    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        Order order = Order.builder()
                .id(rs.getLong("id"))
                .UserID(rs.getLong("userID"))
                .productList(rs.getString("productList"))
                .build();
        return order;
    }
}
