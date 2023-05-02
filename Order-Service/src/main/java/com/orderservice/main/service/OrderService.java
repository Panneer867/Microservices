package com.orderservice.main.service;

import com.orderservice.main.model.OrderRequest;

public interface OrderService {

	long placeOrder(OrderRequest orderRequest);

}
