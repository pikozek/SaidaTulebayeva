package com.example.projectOneJDBC.repository;

import com.example.projectOneJDBC.dto.User;
import com.example.projectOneJDBC.mapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Repository
@Transactional
public class UserRepo {
    private final JdbcTemplate jdbcTemplate;
    private final UserRowMapper userRowMapper;

    @Autowired
    public UserRepo(JdbcTemplate jdbcTemplate, UserRowMapper userRowMapper){
        this.jdbcTemplate = jdbcTemplate;
        this.userRowMapper = userRowMapper;
    }

    public User save(User user){
        String sql = "INSERT INTO users(name, orderList) VALUES(?, ?)";
        jdbcTemplate.update(sql, user.getName(), user.getOrders());
        return user;
    }
    public void delete(User user){
        String sql = "DELETE FROM users WHERE id = ?";
        jdbcTemplate.update(sql, user.getId().intValue());
    }
    public User findById(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, userRowMapper, id);
    }
    public List<User> findAll(){
        String sql = "SELECT * FROM users";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        return rows.stream()
                .map(this::mapRowToUser)
                .collect(Collectors.toList());
    }
    public User mapRowToUser(Map<String, Object> row) {
        User user = User.builder()
                .id(((Number)row.get("id")).longValue())
                .name((String)row.get("name"))
                .orders((String) row.get("orderList"))
                .build();
        return user;
    }
}
