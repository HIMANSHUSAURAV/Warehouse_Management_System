package com.jsp.warehouse.utility;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.warehouse.exception.IllegalOperationException;

@RestControllerAdvice
public class ApplicationHandler {
	
	@ExceptionHandler 
	 public ResponseEntity<ErrorStructure<Map<String, String>>> handleMethodArugumentNotValid(MethodArgumentNotValidException ex){ 
	   List<ObjectError> errors =ex.getAllErrors(); 
	   Map<String , String> allError= new HashMap<String, String>(); 
	   errors.forEach( error ->{ 
	    FieldError fieldError = ( FieldError)errors; 
	    String field= fieldError.getField(); 
	    String message =fieldError.getDefaultMessage(); 
	    allError.put(field, message); 
	       
	   }); 
	   return ResponseEntity.status(HttpStatus.BAD_REQUEST) 
	     .body(new ErrorStructure< Map<String , String>>().setStatus(HttpStatus.BAD_REQUEST.value()) 
	       .setMessage("invalid input") 
	       .setRootCause(allError)); 
	      
	    
	 } 
	    
	 public ResponseEntity<ErrorStructure<String>> errorResponse  ( HttpStatus status , String message , String routcase){ 
	   return  ResponseEntity.status(status).body(new ErrorStructure() 
	     .setMessage(message) 
	     .setStatus(status.value()) 
	     .setRootCause(routcase) 
	    ); 
	  } 
	  @ExceptionHandler 
	  public ResponseEntity<ErrorStructure<String>> handleSuperAdminAlreadyExist(IllegalOperationException ex){ 
	   return errorResponse(HttpStatus.FORBIDDEN,  ex.getMessage(),  "the admin must be only one"); 
	  }
	
	
}
