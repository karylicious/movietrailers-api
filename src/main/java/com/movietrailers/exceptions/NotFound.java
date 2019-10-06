package com.movietrailers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST) //404
public class NotFound extends Exception  {

	private static final long serialVersionUID = -3332292346834265371L;

	public NotFound(String message){		
		super(message);
		System.out.println("aaa");
		//super("EmployeeNotFoundException with id="+id);
	}
	
	
	
}
