package com.orderservice.main.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OrderRequest {

	private long productId;
	private long quantity;
	private long totalAmount;
	private PaymentMode paymentMode;
	
}
