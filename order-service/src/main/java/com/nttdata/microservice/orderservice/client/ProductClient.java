package com.nttdata.microservice.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

// We just define a placeholder DTO if we needed it, but for simulation we might just return generic objects or strings
@FeignClient(name = "product-service")
public interface ProductClient {
    @GetMapping("/produtos")
    List<Object> getAllProducts();
}
