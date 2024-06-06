package com.jsp.warehouse.exception;

public class IllegalOperationException extends RuntimeException {
	
	private String message;
	
	public IllegalOperationException(String message) {
		this.message=message;
	}
	@Override
	public String getMessage() {
		return this.message;
	}
}
