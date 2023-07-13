package org.example;

import org.example.dto.Order;
import org.example.dto.Product;
import org.example.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        MyService myService = context.getBean(MyService.class);
        List<Product> products = new ArrayList<>();
        User user = User.builder()
                .id(1L)
                .name("Pikozek")
                .build();
        Order order = Order.builder()
                .id(1L)
                .orderId("Order-1")
                .user(user)
                .build();
        user.setOrder(order);
        Product product = Product.builder()
                .id(1L)
                .name("Cake")
                .price(8000)
                .build();
        Product product1 = Product.builder()
                .id(2L)
                .name("Cupcake")
                .price(500)
                .build();
        products.add(product);
        products.add(product1);
        order.setProducts(products);
        System.out.println(user.getName() + "'s order: ");
        Order example = user.getOrder();
        if(example != null){
            List<Product> p = example.getProducts();
            p.stream()
                    .map(Product::getName)
                    .forEach(System.out::println);
        }else{
            System.out.println("There are no orders! Oh no!");
        }
    }
}
