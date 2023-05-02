package com.productservice.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productservice.main.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
