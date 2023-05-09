package com.orderservice.main.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderservice.main.entity.Order;
import com.orderservice.main.external.client.PaymentService;
import com.orderservice.main.external.client.ProductService;
import com.orderservice.main.external.request.PaymentRequest;
import com.orderservice.main.model.OrderRequest;
import com.orderservice.main.repository.OrderRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class OrderserviceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private PaymentService paymentService;
	
	@Override
	public long placeOrder(OrderRequest orderRequest) {
		
		log.info("Placing Order Request: {}",orderRequest);
		
		productService.reduceQuantity(orderRequest.getProductId(), orderRequest.getQuantity());
		
		log.info("Creating order with status CREATED");
		Order order = Order.builder()
				.amount(orderRequest.getTotalAmount())
				.OrderStatus("CREATED")
				.productId(orderRequest.getProductId())
				.orderDate(Instant.now())
				.quantity(orderRequest.getQuantity())
				.build();
		
		order = orderRepository.save(order);
		
		log.info("Calling Payment Service to complete the payment : {}");
		
		PaymentRequest paymentRequest = PaymentRequest.builder()
				.orderId(order.getId())
				.paymentMode(orderRequest.getPaymentMode())
				.amount(orderRequest.getTotalAmount())
				.build();
		
		String orderStatus = null;
		
		try {
			paymentService.doPayment(paymentRequest);
			
			log.info("Payment done Successfully. Changing the order Status to PLACED: {}");
			
			orderStatus = "PLACED";

		} catch (Exception e) {
			log.error("Error occured in payment. Changing the order status to PAYMENT_FAILED");
			
			orderStatus = "PAYMENT_FAILED";
		}
		
		order.setOrderStatus(orderStatus);
		
		orderRepository.save(order);
		
		log.info("Order Places successfully with Order Id: {}", order.getId());
		
		return order.getId();
	}

}
