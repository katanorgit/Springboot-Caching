package com.rkatanor.springbootrestapi.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ProductExecptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<Object> handleProductNotFound(ProductNotFoundException ex, WebRequest req) {
		return new ResponseEntity<Object>(new ApiErrors(ex.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now()),
				HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(ProductFoundException.class)
	public ResponseEntity<Object> handleProductFound(ProductFoundException ex, WebRequest req) {
		return new ResponseEntity<Object>(new ApiErrors(ex.getMessage(), HttpStatus.FOUND, LocalDateTime.now()),
				HttpStatus.FOUND);

	}

}
