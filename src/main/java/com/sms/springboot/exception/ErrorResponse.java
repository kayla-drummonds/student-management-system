package com.sms.springboot.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ErrorResponse {
	private HttpStatus httpStatus;
	private String message;
	
	public ErrorResponse(int value, String message, long currentTimeMillis) {

	}
	
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	
	public String getMessage() {
		return message;
	}

}
