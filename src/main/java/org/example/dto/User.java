package org.example.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Builder
@Setter
public class User {
    private int id;
    private String name;
    private List<Order> orders;
}
