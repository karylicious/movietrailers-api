package com.movietrailers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST) 
public class MismatchedTypeException extends Exception  {

	private static final long serialVersionUID = -3332292346834265371L;

	public MismatchedTypeException(String message){		
		super(message);
	}
}