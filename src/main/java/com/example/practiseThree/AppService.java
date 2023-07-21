package com.example.practiseThree;

import com.example.practiseThree.dto.Order;
import com.example.practiseThree.dto.Product;
import com.example.practiseThree.dto.User;
import com.example.practiseThree.service.OrderService;
import com.example.practiseThree.service.ProductService;
import com.example.practiseThree.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AppService {
    private UserService userService;
    private ProductService productService;
    private OrderService orderService;
    @Autowired
    public AppService(UserService userService, ProductService productService, OrderService orderService){
        this.productService = productService;
        this.orderService = orderService;
        this.userService = userService;
    }
    public User saveUser(User user){
        if(userService.findUserById(user.getId()) != null){
            return userService.updateUser(user);
        }
        return userService.saveUser(user);
    }
    public Order saveOrder(Order order){
        if(orderService.findOrderById(order.getId()) != null){
            return orderService.updateOrder(order);
        }
        return orderService.saveOrder(order);
    }
    public Product saveProduct(Product product){
        if(productService.findProductById(product.getId()) != null){
            return productService.updateProduct(product);
        }
        return productService.saveProduct(product);
    }
    public List<User> saveUsers(List<User> users){
        return userService.saveUsers(users);
    }
    public List<Order> saveOrders(List<Order> orders){
        return orderService.saveOrders(orders);
    }
    public List<Product> saveProducts(List<Product> products){
        return productService.saveProducts(products);
    }
    public List<User> findAllUsers(){
        return userService.getUsers();
    }
    public List<Order> findAllOrders(){
        return orderService.getOrders();
    }
    public List<Product> findAllProducts(){
        return productService.getProducts();
    }
    public User findUserById(int id){
        return userService.findUserById(id);
    }
    public Order findOrderById(int id){
        return orderService.findOrderById(id);
    }
    public Product findProductById(int id){
        return productService.findProductById(id);
    }
    public void deleteUserById(int id){
        userService.delete(id);
    }
    public void deleteOrderById(int id){
        orderService.delete(id);
    }
    public void deleteProductById(int id){
        productService.delete(id);
    }
}

