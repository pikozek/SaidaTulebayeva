package com.example.projectOneJDBC.mapper;

import com.example.projectOneJDBC.dto.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User>{
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = User.builder()
                .id(rs.getLong("id"))
                .name(rs.getString("name"))
                .orders(rs.getString("orderList"))
                .build();
        return user;
    }
}
