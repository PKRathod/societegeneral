package com.socity.general.util;

public class RestException extends Exception {
	
	String message;
	
	
	public RestException(String message) {
		super();
		this.message = message;
	}

	
}
