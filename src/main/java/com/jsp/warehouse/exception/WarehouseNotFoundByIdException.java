package com.jsp.warehouse.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WarehouseNotFoundByIdException extends RuntimeException{
	private String message;
	
	@Override
	public String getMessage() {
		return this.message;
	}
}
