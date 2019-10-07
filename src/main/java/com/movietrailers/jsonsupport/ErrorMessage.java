package com.movietrailers.jsonsupport;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorMessage {
	@JsonProperty("error_message")
	private String errorMessage;
	
	@JsonProperty("error_code")
	private int errorCode;
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}	
}