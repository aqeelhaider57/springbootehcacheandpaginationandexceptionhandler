package com.cache.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlingStudent extends ResponseEntityExceptionHandler  {
	
	/**
	 * 
	 */
	@ExceptionHandler(NoDataFoundException.class)
	public ResponseEntity<String> deleteException(){
		return new ResponseEntity<String>("Error", HttpStatus.BAD_REQUEST);
	} 
	
	//or
//	@ExceptionHandler(value = {NoDataFoundException.class, CertainException.class})
//	//@ResponseStatus(value = HttpStatus.NOT_FOUND)
//	  public ResponseEntity<ErrorMessage> resourceNotFoundException(NoDataFoundException ex, WebRequest request) {
//	    ErrorMessage message = new ErrorMessage(
//	        status,
//	        date,
//	        ex.getMessage(),
//	        description);
//	    
//	    return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
//	  }

}
