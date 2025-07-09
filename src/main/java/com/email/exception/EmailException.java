package com.email.exception;

public class EmailException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmailException() {
		super("Email Exception");
	}

	public EmailException(String message) {
		super(message);
	}
}
