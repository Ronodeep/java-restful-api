package com.spideron.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {
	private String errorMessage;
	private String errorReference;
	private int errorCode;
	
	public ErrorMessage() {
		
	}
	public ErrorMessage(String errorMessage, String errorReference, int errorCode) {
		super();
		this.errorMessage = errorMessage;
		this.errorReference = errorReference;
		this.errorCode = errorCode;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getErrorReference() {
		return errorReference;
	}
	public void setErrorReference(String errorReference) {
		this.errorReference = errorReference;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	
	
	
}
