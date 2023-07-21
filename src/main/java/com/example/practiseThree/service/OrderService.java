package com.example.practiseThree.service;

import com.example.practiseThree.dto.Order;
import com.example.practiseThree.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order saveOrder(Order order){
        return orderRepository.save(order);
    }
    public List<Order> saveOrders(List<Order> orders){
        return orderRepository.saveAll(orders);
    }
    public Order findOrderById(int id){
        return orderRepository.findById(id).orElse(null);
    }
    public List<Order> getOrders(){
        return orderRepository.findAll();
    }
    @Transactional
    public Order updateOrder(Order order){
        Optional<Order> optionalOrder=orderRepository.findById(order.getId());
        if(optionalOrder.isPresent()){
            Order oldOrder = optionalOrder.get();
            oldOrder.setProductList(order.getProductList());
            oldOrder.setUserID(order.getUserID());
            return orderRepository.save(oldOrder);
        }
        return new Order();
    }
    public String delete(int id){
        orderRepository.deleteById(id);
        return "Order got deleted";
    }
}
