package org.example.repository;

import lombok.RequiredArgsConstructor;
import org.example.dto.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepo implements UserRepository {

    private final JdbcTemplate jdbcTemplate;
    private final String tableName;

    @Override
    public User save(User user) {
        String sql = "INSERT INTO " + tableName + " (id, name) VALUES (?, ?)";
        jdbcTemplate.update(sql, user.getId(), user.getName());
        return user;
    }

    @Override
    public void delete(User user) {
        String sql = "DELETE FROM " + tableName + " WHERE id = ?";
        jdbcTemplate.update(sql, user.getId());
    }
}
