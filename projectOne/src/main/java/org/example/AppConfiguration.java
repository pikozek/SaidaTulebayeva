package org.example;

import org.example.repository.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
    @Bean
    public MyService myService(UserRepository uR, OrderRepository oR, ProductRepository pR){
        return new MyService(uR, oR, pR);
    }
    @Bean
    public UserRepository uR(){
        return new UserRepositoryImpl();
    }
    @Bean
    public OrderRepository oR(){
        return new OrderRepositoryImpl();
    }
    @Bean
    public ProductRepository pR(){
        return new ProductRepositoryImpl();
    }
}
