package com.orderservice.main.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.orderservice.main.external.response.ErrorResponse;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ErrorResponse> handleProductServiceException(CustomException customException) {

		return new ResponseEntity<>(ErrorResponse.builder().errorCode(customException.getErrorCode())
				.errorMessage(customException.getMessage()).build(), HttpStatus.valueOf(customException.getStatus()));

	}

}
