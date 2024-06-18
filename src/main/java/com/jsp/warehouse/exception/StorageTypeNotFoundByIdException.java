package com.jsp.warehouse.exception;

public class StorageTypeNotFoundByIdException extends RuntimeException{
	
	private String message;

	public StorageTypeNotFoundByIdException(String message) {
		super();
		this.message = message;
	}
	
	

}
