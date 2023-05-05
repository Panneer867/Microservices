package com.orderservice.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orderservice.main.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
