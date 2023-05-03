package com.productservice.main.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductServiceCustomException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String errCode;

	public ProductServiceCustomException(String message, String errCode) {
		super(message);
		this.errCode = errCode;
	}

}
