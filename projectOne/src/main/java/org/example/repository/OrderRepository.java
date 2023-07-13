package org.example.repository;

import org.example.dto.Order;

import java.util.List;

public interface OrderRepository {
    Order save(Order order);
    Order findById(Long id);
    List<Order> findAll();
    void delete(Order order);
}
