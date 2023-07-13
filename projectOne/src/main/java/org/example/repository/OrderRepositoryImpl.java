package org.example.repository;

import lombok.RequiredArgsConstructor;
import org.example.dto.Order;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {
    private final List<Order> orders = new ArrayList<>();
    @Override
    public Order save(Order order) {
        orders.add(order);
        return order;
    }
    @Override
    public Order findById(Long id) {
        return orders.stream()
                .filter(order -> order.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    @Override
    public List<Order> findAll() {
        return new ArrayList<>(orders);
    }
    @Override
    public void delete(Order order) {
        orders.remove(order);
    }
}
