package com.example.practiseThree.service;

import com.example.practiseThree.dto.User;
import com.example.practiseThree.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user){
        return userRepository.save(user);
    }
    public List<User> saveUsers(List<User> users){
        return userRepository.saveAll(users);
    }
    public User findUserById(int id){
        return userRepository.findById(id).orElse(null);
    }
    public List<User> getUsers(){
        return userRepository.findAll();
    }
   @Transactional
    public User updateUser(User user){
        Optional<User> optionalUser=userRepository.findById(user.getId());
        if(optionalUser.isPresent()){
            User oldUser = optionalUser.get();
            oldUser.setName(user.getName());
            oldUser.setOrders(user.getOrders());
            return userRepository.save(oldUser);
        }
        return new User();
    }
    public String delete(int id){
        userRepository.deleteById(id);
        return "User got deleted";
    }
}
