package com.rkatanor.springbootrestapi.exceptions;

public class ProductFoundException extends RuntimeException {
	
	public ProductFoundException(String message) {
		super(message);
	}

}
