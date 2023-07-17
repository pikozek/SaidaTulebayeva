package org.example.repository;

import org.example.dto.Order;

public interface OrderRepository {
    Order save(Order order);

    void delete(Order order);
}
