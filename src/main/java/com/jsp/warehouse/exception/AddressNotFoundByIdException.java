package com.jsp.warehouse.exception;

public class AddressNotFoundByIdException extends RuntimeException{

	private String string;

	public AddressNotFoundByIdException(String string) {
		super();
		this.string = string;
	}

	public String getString() {
		return string;
	}
	
	
	
}
