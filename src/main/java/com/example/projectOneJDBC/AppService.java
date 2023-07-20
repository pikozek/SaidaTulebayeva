package com.example.projectOneJDBC;

import com.example.projectOneJDBC.dto.Order;
import com.example.projectOneJDBC.dto.Product;
import com.example.projectOneJDBC.dto.User;
import com.example.projectOneJDBC.service.OrderService;
import com.example.projectOneJDBC.service.ProductService;
import com.example.projectOneJDBC.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppService {
    private final UserService userService;
    private final OrderService orderService;
    private final ProductService productService;

    @Autowired
    public AppService(UserService uS, OrderService oS, ProductService pS){
        this.userService = uS;
        this.orderService = oS;
        this.productService = pS;
    }

    public void saveUser(User user){
        userService.saveOrUpdate(user);
    }
    public void deleteUser(User user){
        userService.deleteUser(user);
    }
    public List<User> findAllUsers(){
        return userService.getAllUsers();
    }
    public User findUserById(int id){
        return userService.getUserById(id);
    }
    public void saveOrder(Order order){
        orderService.saveOrUpdate(order);
    }
    public void deleteOrder(Order order){
        orderService.deleteOrder(order);
    }
    public List<Order> findAllOrders(){
        return orderService.getAllOrders();
    }
    public Order findOrderById(int id){
        return orderService.getOrderById(id);
    }
    public void saveProduct(Product product){
        productService.saveOrUpdate(product);
    }
    public void deleteProduct(Product product){
        productService.deleteProduct(product);
    }
    public List<Product> findAllProducts(){
        return productService.getAllProducts();
    }
    public Product findProductById(int id){
        return productService.getProductById(id);
    }
}

