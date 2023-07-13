package org.example.repository;

import lombok.RequiredArgsConstructor;
import org.example.dto.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository{
    private final List<User> users = new ArrayList<>();

    @Override
    public User save(User user){
        users.add(user);
        return user;
    }
    @Override
    public User findById(Long id){
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    @Override
    public List<User> findAll(){
        return new ArrayList<>(users);
    }
    @Override
    public void delete(User user){
        users.remove(user);
    }
}
