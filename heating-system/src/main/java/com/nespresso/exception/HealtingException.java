package com.nespresso.exception;

public class HealtingException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private String code;
	private String message;

	public HealtingException(String message, String code) {
		super(message);
		this.code = code;
	}

}
