package com.nttdata.microservice.productservice.repository;

import com.nttdata.microservice.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
