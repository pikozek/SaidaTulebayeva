package org.example;

import org.example.dto.Order;
import org.example.dto.Product;
import org.example.dto.User;
import org.example.repository.OrderRepository;
import org.example.repository.ProductRepository;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

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

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
    public Order getUserOrder(Long userId) {
        User user = userRepository.findById(userId);
        if (user != null) {
            return user.getOrder();
        }
        return null;
    }
}
