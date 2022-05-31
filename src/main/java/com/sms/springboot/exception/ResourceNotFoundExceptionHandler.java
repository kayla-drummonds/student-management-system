package com.sms.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceNotFoundExceptionHandler {

		@ExceptionHandler
		public ResponseEntity<ErrorResponse> handleException(ResourceNotFoundException exc) {
			ErrorResponse error = new ErrorResponse(
												HttpStatus.NOT_FOUND.value(),
												exc.getMessage(), 
												System.currentTimeMillis());
			return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		}
	
}
