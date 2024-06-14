package com.jsp.warehouse.exception;

public class ClientNotFoundByIdException extends RuntimeException {
	
	private String message;

	public ClientNotFoundByIdException(String meessage) {
		this.message = meessage;
	}
	
	
	

}
