package com.orderservice.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.orderservice.main.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
