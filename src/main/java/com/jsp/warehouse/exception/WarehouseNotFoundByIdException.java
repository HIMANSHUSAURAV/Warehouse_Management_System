package com.jsp.warehouse.exception;

public class WarehouseNotFoundByIdException extends RuntimeException{

	public WarehouseNotFoundByIdException(String message) {
        super(message);
    }
	
	@Override
	public String getMessage() {
		return this.getMessage();
	}
}
