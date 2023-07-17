package org.example.repository;

import org.example.dto.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class OrderRepo implements OrderRepository {

    private final JdbcTemplate jdbcTemplate;
    private final String tableName;

    @Override
    public Order save(Order order) {
        String sql = "INSERT INTO " + tableName + " (id, orderid, user_id) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, order.getId(), order.getOrderId(), order.getUser().getId());
        return order;
    }

    @Override
    public void delete(Order order) {
        String sql = "DELETE FROM " + tableName + " WHERE id = ?";
        jdbcTemplate.update(sql, order.getId());
    }
}
