package org.example.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Builder
@Setter
public class Order {
    private int id;
    private String orderId;
    private User user;
    private List<Product> products;
}
