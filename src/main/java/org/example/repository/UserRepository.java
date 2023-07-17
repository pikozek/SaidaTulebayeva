package org.example.repository;

import org.example.dto.User;

public interface UserRepository {
    User save(User user);

    void delete(User user);
}
