package com.tech.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandleException {

	
	public HandleException() {
		System.out.println("Inside Exception handeler");
	}
	
	@ExceptionHandler(value = ResourceNotFound.class)
	public ResponseEntity<Object> exception(ResourceNotFound ex){
		System.out.println("----inside handleException---");
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
}
