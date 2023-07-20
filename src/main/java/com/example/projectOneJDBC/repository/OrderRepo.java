package com.example.projectOneJDBC.repository;

import com.example.projectOneJDBC.dto.Order;
import com.example.projectOneJDBC.dto.Product;
import com.example.projectOneJDBC.mapper.OrderRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
@Transactional
public class OrderRepo {
    private final JdbcTemplate jdbcTemplate;
    private final OrderRowMapper orderRowMapper;

    @Autowired
    public OrderRepo(JdbcTemplate jdbcTemplate, OrderRowMapper orderRowMapper){
        this.jdbcTemplate = jdbcTemplate;
        this.orderRowMapper = orderRowMapper;
    }
    public Order save(Order order){
        String productList = order.getProducts().stream()
                .map(Product::getProductName)
                .collect(Collectors.joining(", "));
        String sql ="INSERT INTO orders(userID, productList) VALUES(?, ?)";
        jdbcTemplate.update(sql, order.getUserID().intValue(), productList);
        return order;
    }
    public void delete(Order order){
        String sql = "DELETE FROM orders WHERE id = ?";
        jdbcTemplate.update(sql, order.getId().intValue());
    }
    public Order findById(int id) {
        String sql = "SELECT * FROM orders WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, orderRowMapper, id);
    }
    public List<Order> findAll(){
        String sql = "SELECT * FROM orders";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        return rows.stream()
                .map(this::mapToOrder)
                .collect(Collectors.toList());
    }
    public Order mapToOrder(Map<String, Object> row) {
        Order order = Order.builder()
                .id(((Number)row.get("id")).longValue())
                .productList((String)row.get("productList"))
                .UserID(((Number)row.get("UserID")).longValue())
                .build();
        return order;
    }
}
