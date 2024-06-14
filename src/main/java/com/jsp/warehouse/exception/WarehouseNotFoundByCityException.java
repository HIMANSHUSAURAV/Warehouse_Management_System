package com.jsp.warehouse.exception;

public class WarehouseNotFoundByCityException extends RuntimeException {


	private String message;

	public WarehouseNotFoundByCityException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}


}
