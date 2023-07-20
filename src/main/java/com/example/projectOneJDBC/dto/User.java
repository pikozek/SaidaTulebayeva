package com.example.projectOneJDBC.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class User {
    private Long id;
    private String name;
    private String orders;
}
