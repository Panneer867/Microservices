package com.orderservice.main.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String errorCode;
	private int status;

	public CustomException(String message, String errorCode, int status) {

		super(message);
		this.errorCode = errorCode;
		this.status = status;
	}

}
