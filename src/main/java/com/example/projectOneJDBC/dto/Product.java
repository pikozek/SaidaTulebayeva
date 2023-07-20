package com.example.projectOneJDBC.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class Product {
    private Long id;
    private String productName;
    private int price;
}
