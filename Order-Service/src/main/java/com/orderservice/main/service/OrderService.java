package com.orderservice.main.service;

import com.orderservice.main.model.OrderRequest;
import com.orderservice.main.model.OrderResponse;

public interface OrderService {

	long placeOrder(OrderRequest orderRequest);

	OrderResponse getOrderDetails(long orerId);

}
