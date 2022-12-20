package com.rkatanor.springbootrestapi.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ApiErrors {
	public String message;
	public HttpStatus status;
	public LocalDateTime localDateTime;

	public ApiErrors(String message, HttpStatus status, LocalDateTime localDateTime) {
		super();
		this.message = message;
		this.status = status;
		this.localDateTime = localDateTime;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}
	

}
