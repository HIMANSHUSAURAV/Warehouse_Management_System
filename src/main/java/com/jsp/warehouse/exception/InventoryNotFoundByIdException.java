package com.jsp.warehouse.exception;

public class InventoryNotFoundByIdException extends RuntimeException {

	
	private String message;

	public InventoryNotFoundByIdException(String message) {
		super();
		this.message = message;
	}
	
	
}
