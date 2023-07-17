package org.example;

import javax.sql.DataSource;
import org.example.repository.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@EnableAspectJAutoProxy
public class AppConfiguration {
    @Value("jdbc:postgresql://localhost:5432")
    private String databaseUrl;

    @Value("firstDB")
    private String databaseName;

    @Value("postgres")
    private String databaseUsername;

    @Value("12345")
    private String databasePassword;

    @Value("users")
    private String userTableName;

    @Value("orders")
    private String orderTableName;

    @Value("products")
    private String productTableName;

    @Bean
    public JdbcTemplate userJdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public JdbcTemplate orderJdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public JdbcTemplate productJdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(databaseUrl + "/" + databaseName);
        dataSource.setUsername(databaseUsername);
        dataSource.setPassword(databasePassword);
        return dataSource;
    }

    @Bean
    public MyService myService(UserRepository uR, OrderRepository oR, ProductRepository pR) {
        return new MyService(uR, oR, pR);
    }

    @Bean
    public UserRepository uR() {
        return new UserRepo(userJdbcTemplate(), userTableName);
    }

    @Bean
    public OrderRepository oR() {
        return new OrderRepo(orderJdbcTemplate(), orderTableName);
    }

    @Bean
    public ProductRepository pR() {
        return new ProductRepo(productJdbcTemplate(), productTableName);
    }
}
