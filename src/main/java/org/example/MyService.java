package org.example;

import lombok.Getter;
import org.example.dto.Order;
import org.example.dto.Product;
import org.example.dto.User;
import org.example.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Getter
public class MyService {
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Autowired
    public MyService(UserRepository uR, OrderRepository oR, ProductRepository pR) {
        this.userRepository = uR;
        this.orderRepository = oR;
        this.productRepository = pR;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<Order> saveOrders(List<Order> orders) {
        return orders.stream()
                .map(orderRepository::save)
                .collect(Collectors.toList());
    }

    public List<Product> saveProducts(List<Product> products) {
        return products.stream()
                .map(productRepository::save)
                .collect(Collectors.toList());
    }
}
