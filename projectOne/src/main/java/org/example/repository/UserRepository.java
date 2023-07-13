package org.example.repository;

import org.example.dto.User;

import java.util.List;

public interface UserRepository {
    User save(User user);
    User findById(Long id);
    List<User> findAll();
    void delete(User user);
}
