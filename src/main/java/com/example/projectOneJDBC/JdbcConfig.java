package com.example.projectOneJDBC;

import com.example.projectOneJDBC.dto.Product;
import com.example.projectOneJDBC.mapper.OrderRowMapper;
import com.example.projectOneJDBC.mapper.ProductRowMapper;
import com.example.projectOneJDBC.mapper.UserRowMapper;
import com.example.projectOneJDBC.repository.OrderRepo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.example.projectOneJDBC")
@EnableAspectJAutoProxy
public class JdbcConfig {
    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:schema.sql")
                .addScript("classpath:test-data.sql")
                .build();
    }
    @Bean
    public UserRowMapper userRowMapper(){
        return new UserRowMapper();
    }
    @Bean
    public OrderRowMapper orderRowMapper(){
        return new OrderRowMapper();
    }
    @Bean
    public ProductRowMapper productRowMapper(){
        return new ProductRowMapper();
    }
}
