package com.micro.services.exception;

public class EmployeNotFoundException  extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmployeNotFoundException(String message) {
		super(message);
	}

}
