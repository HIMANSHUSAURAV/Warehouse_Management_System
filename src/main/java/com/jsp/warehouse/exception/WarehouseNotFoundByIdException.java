package com.jsp.warehouse.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class WarehouseNotFoundByIdException extends RuntimeException{
	private String message;
	
}
