package org.example.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@Setter
public class User {
    private Long id;
    private String name;
    private Order order;
}
