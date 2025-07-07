package com.order.order;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
public ResponseEntity<String> handleResourceNotFound(ResourceNotFoundException ex){
	return new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
}
@ExceptionHandler(DuplicateResourceException.class)
public ResponseEntity<String> handleDuplicateResource(DuplicateResourceException ex) {
	return new 	ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
}
@ExceptionHandler(Exception.class)
public ResponseEntity<String> handleOtherExceptions(Exception ecx){
	return new ResponseEntity<String>(ecx.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
}
}
