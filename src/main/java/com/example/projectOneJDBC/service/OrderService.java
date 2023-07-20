package com.example.projectOneJDBC.service;

import com.example.projectOneJDBC.dto.Order;
import com.example.projectOneJDBC.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepo orderRepo;
    public Order getOrderById(int id){
        return orderRepo.findById(id);
    }
    public List<Order> getAllOrders(){
        return orderRepo.findAll();
    }
    public void saveOrUpdate(Order order){
        orderRepo.save(order);
    }
    public void deleteOrder(Order order){
        orderRepo.delete(order);
    }
}
