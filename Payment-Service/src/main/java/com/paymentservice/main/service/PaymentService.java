package com.paymentservice.main.service;

import com.paymentservice.main.model.PaymentRequest;

public interface PaymentService {

	long doPayment(PaymentRequest paymentRequest);

}
