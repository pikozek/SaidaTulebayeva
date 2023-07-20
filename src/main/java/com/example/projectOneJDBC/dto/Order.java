package com.example.projectOneJDBC.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Builder
public class Order {
    private Long id;
    private Long UserID;
    private List<Product> products;
    private String productList;
}
