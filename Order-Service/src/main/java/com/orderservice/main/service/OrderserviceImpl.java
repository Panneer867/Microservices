package com.orderservice.main.service;

import java.time.Instant;

import org.springframework.stereotype.Service;

import com.orderservice.main.entity.Order;
import com.orderservice.main.model.OrderRequest;
import com.orderservice.main.repository.OrderRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class OrderserviceImpl implements OrderService {
	
	private OrderRepository orderRepository;
	
	@Override
	public long placeOrder(OrderRequest orderRequest) {
		
		
		log.info("Placing Order Request: {}",orderRequest);
		Order order = Order.builder()
				.amount(orderRequest.getTotalAmount())
				.OrderStatus("CREATED")
				.productId(orderRequest.getProductId())
				.orderDate(Instant.now())
				.build();
		
		orderRepository.save(order);
		
		log.info("Order Places successfully with Order Id: {}", order.getId());
		
		return order.getId();
	}

}
