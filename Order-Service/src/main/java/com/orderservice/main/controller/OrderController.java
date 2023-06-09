package com.orderservice.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orderservice.main.model.OrderRequest;
import com.orderservice.main.model.OrderResponse;
import com.orderservice.main.service.OrderService;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping("/placeorder")
	public ResponseEntity<Long> placeOrder(@RequestBody OrderRequest orderRequest) {
		long orderId = orderService.placeOrder(orderRequest);
		log.info("Order Id: {}", orderId);
		return new ResponseEntity<>(orderId, HttpStatus.OK);

	}

	@GetMapping("/{orderId}")
	public ResponseEntity<OrderResponse> getOrderDetails(@PathVariable("orderId") long orerId) {

		OrderResponse orderResponse = orderService.getOrderDetails(orerId);
		return new ResponseEntity<>(orderResponse, HttpStatus.OK);
	}
}
