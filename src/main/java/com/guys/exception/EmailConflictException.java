package com.guys.exception;

public class EmailConflictException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6532460188244419636L;

	public EmailConflictException() {
		// TODO Auto-generated constructor stub
	}

	public EmailConflictException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public EmailConflictException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public EmailConflictException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public EmailConflictException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
}
