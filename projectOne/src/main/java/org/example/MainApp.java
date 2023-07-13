package org.example;

import org.example.dto.Order;
import org.example.dto.Product;
import org.example.dto.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        MyService myService = context.getBean(MyService.class);
        //User
        User user = new User();
        user.setName("user1");
        user.setId(1L);
        myService.saveUser(user);
        //The order
        Order order = new Order();
        order.setOrderId("Order-1");
        order.setUser(user);
        user.setOrder(order);
        myService.saveOrder(order);
        //The List of Products
        List<Product> products = new ArrayList<>();
        //The product cake
        Product cake = new Product();
        cake.setName("Cake");
        cake.setPrice(8000);
        products.add(cake);
        myService.saveProduct(cake);
        //The product cupcake
        Product cupcake = new Product();
        cupcake.setName("Cupcakes");
        cupcake.setPrice(500);
        products.add(cupcake);
        myService.saveProduct(cupcake);
        order.setProducts(products);
        Order userOrder = myService.getUserOrder(user.getId());
        System.out.print("User Order: ");
        List<Product> toPrint = userOrder.getProducts();
        for (Product product : toPrint) {
            System.out.print(product.getName() + " ");
        }
    }
}
