package com.paymentservice.main.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paymentservice.main.entity.TransactionDetails;
import com.paymentservice.main.model.PaymentRequest;
import com.paymentservice.main.repository.TransactionDetailsRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private TransactionDetailsRepository detailsRepository;

	@Override
	public long doPayment(PaymentRequest paymentRequest) {
		log.info("Recording Payment Details: {}", paymentRequest);
		
		TransactionDetails details = 
				TransactionDetails.builder()
				.paymentDate(Instant.now())
				.paymentMode(paymentRequest.getPaymentMode().name())
				.paymentStatus("SUCCESS")
				.orderId(paymentRequest.getOrderId())
				.referenceNumber(paymentRequest.getReferenceNumber())
				.amount(paymentRequest.getAmount()).build();
		
		detailsRepository.save(details);
		
		log.info("Transaction Completed with ID: {}", details.getId());

		
		return  details.getId();
	}

}
