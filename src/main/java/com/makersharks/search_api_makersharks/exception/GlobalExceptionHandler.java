package com.makersharks.search_api_makersharks.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value=TaskNotFoundException.class)
	public ResponseEntity<?> handler(TaskNotFoundException e){
		return new ResponseEntity<>("Supplier not found with given id , Please Check"
				,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(value=HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<?> handlerNotSupported(HttpRequestMethodNotSupportedException e){
		return new ResponseEntity<>("Please make a valid request For Supplier , Please check"
				,HttpStatus.METHOD_NOT_ALLOWED);
		
	}
	
	@ExceptionHandler(value=NoDataException.class)
	public ResponseEntity<?> handlerNoData(NoDataException e){
		return new ResponseEntity<>("Opps !!!! No records available   !!!!!!"
				,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(value=HttpMessageNotReadableException.class)
	public ResponseEntity<?> handlerNotReadable(HttpMessageNotReadableException e){
		return new ResponseEntity<>("Please provide Supplier details in request body.?"
				,HttpStatus.BAD_REQUEST);
		
	}

}
