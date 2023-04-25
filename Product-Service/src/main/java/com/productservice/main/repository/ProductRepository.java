package com.productservice.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.productservice.main.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
