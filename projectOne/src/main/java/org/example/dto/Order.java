package org.example.dto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;

import java.util.List;
@Getter
@Builder
@Setter
public class Order {
    private Long id;
    private String orderId;
    private User user;
    private List<Product> products;
}
