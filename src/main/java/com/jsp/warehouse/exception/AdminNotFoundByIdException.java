package com.jsp.warehouse.exception;

public class AdminNotFoundByIdException extends RuntimeException{

	private String  string;

	public AdminNotFoundByIdException(String string) {
		super();
		this.string = string;
	}

	public String getString() {
		return string;
	}
	
}
