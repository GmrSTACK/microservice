package com.nttdata.microservice.orderservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Long id;
    private List<Long> productIds;
    // In a real app we might store more details or lines
}
