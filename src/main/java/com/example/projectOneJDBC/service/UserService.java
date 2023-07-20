package com.example.projectOneJDBC.service;

import com.example.projectOneJDBC.dto.User;
import com.example.projectOneJDBC.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public User getUserById(int id){
        return userRepo.findById(id);
    }
    public List<User> getAllUsers(){
        return userRepo.findAll();
    }
    public void saveOrUpdate(User user){
        userRepo.save(user);
    }
    public void deleteUser(User user){
        userRepo.delete(user);
    }

}
