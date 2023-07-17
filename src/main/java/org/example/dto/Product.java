package org.example.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Product {
    private int id;
    private String name;
    private int price;
    private int purchaseCount;
}
