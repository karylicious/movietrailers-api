package com.movietrailers.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.movietrailers.jsonsupport.ErrorMessage;

@ControllerAdvice
public class DefaultExceptionHandler {

	
	@ExceptionHandler({NotFound.class})
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public String handle(NotFound e){
		//return "hi";
		ErrorMessage response = new ErrorMessage();
		response.setErrorCode(404);
		response.setErrorMessage(e.getMessage());
		System.out.println("oo");
		return convertObjectToJson(response);
	}
	
	private static String convertObjectToJson(Object objectToBeConverted){
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(objectToBeConverted);
		}
		catch(Exception exception) {
			exception.printStackTrace();
		}
		return null;
	}
}
