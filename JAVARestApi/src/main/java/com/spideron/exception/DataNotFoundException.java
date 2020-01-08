package com.spideron.exception;

public class DataNotFoundException extends RuntimeException{

	/**
	 * This exception class 
	 */
	private static final long serialVersionUID = -8196020553768626677L;
	
	public DataNotFoundException(String errormessage) {
		super(errormessage);
	}
}
