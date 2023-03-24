package com.micro.services.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.micro.services.model.ErrorMessage;

@ControllerAdvice
public class RestResponseEntityHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EmployeNotFoundException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessage employeeNotFoundHandler(EmployeNotFoundException employeNotFoundException) {
		
		ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND, employeNotFoundException.getMessage());
		return errorMessage;

	}

}
