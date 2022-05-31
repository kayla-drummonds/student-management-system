package com.sms.springboot.exception;

public class UserAlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7041590162260928202L;
	
	private String username;
	
	public UserAlreadyExistsException(String username) {
		this.username = username;
	}
	
	@Override
	public String getMessage() {
		return String.format("User with username : " + username + " already exists\n");
	}
}