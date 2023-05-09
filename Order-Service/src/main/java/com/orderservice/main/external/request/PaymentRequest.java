package com.orderservice.main.external.request;


import com.orderservice.main.model.PaymentMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentRequest {
	
	private long orderId;
	private long amount;
	private PaymentMode paymentMode;
	private String referenceNumber;

}
