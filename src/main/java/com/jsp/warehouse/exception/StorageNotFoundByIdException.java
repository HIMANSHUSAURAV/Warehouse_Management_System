package com.jsp.warehouse.exception;

public class StorageNotFoundByIdException extends RuntimeException {

	private String message;

	public StorageNotFoundByIdException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	
	
	
}
