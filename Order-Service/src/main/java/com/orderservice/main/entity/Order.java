package com.orderservice.main.entity;

import java.time.Instant;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "ORDER_DETAILS")
@Data
@Builder
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long productId;
	private long quantity;
	private Instant orderDate;
	private String OrderStatus;
	private long amount;
	
}
