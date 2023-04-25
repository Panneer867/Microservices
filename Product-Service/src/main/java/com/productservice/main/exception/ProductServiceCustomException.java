package com.productservice.main.exception;

import lombok.Data;

@Data
public class ProductServiceCustomException extends RuntimeException {
	
	private String errCode;

	public ProductServiceCustomException(String message, String errCode) {
		super(message);
		this.errCode = errCode;
	}
	
	
	

}
