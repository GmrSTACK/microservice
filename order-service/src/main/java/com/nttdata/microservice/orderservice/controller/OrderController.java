package com.nttdata.microservice.orderservice.controller;

import com.nttdata.microservice.orderservice.client.ProductClient;
import com.nttdata.microservice.orderservice.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
@Slf4j
public class OrderController {

    @Autowired
    private ProductClient productClient;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createOrder(@RequestBody Order order) {
        log.info("Received order request for products: {}", order.getProductIds());

        // Simulation: Call product service just to verify connectivity or check
        // products
        List<Object> products = productClient.getAllProducts();
        log.info("Available products: {}", products);

        return "Order created successfully for " + order.getProductIds().size() + " items.";
    }
}
