package com.example.practiseThree;

import com.example.practiseThree.dto.User;
import com.example.practiseThree.service.OrderService;
import com.example.practiseThree.service.ProductService;
import com.example.practiseThree.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class AppServiceTest {

    @Autowired
    private AppService appService;

    @Test
    public void shouldCreateUser(){
        User user = new User(1, "Pikozek", "1, 2");
        appService.saveUser(user);
    }
    @Test
    public void shouldCreateMultipleUsers(){
        List<User> users = new ArrayList<>();
        User user = new User(1, "Ramen", "1, 2");
        User user1 = new User(2, "Tor", "3");
        User user2 = new User(3, "Ayau", "4, 5, 6");
        users.add(user); users.add(user1); users.add(user2);
        appService.saveUsers(users);
    }
    // я не успела еклмн
//    @Test
//    public void shouldCreateOrder(){
//
//    }
//
//    public void shouldCreateProduct(){
//
//    }
//    public void shouldDeleteUser(){
//
//    }
//    public void shouldDeleteOrder(){
//
//    }
//    public void shouldDeleteProduct(){
//
//    }
}