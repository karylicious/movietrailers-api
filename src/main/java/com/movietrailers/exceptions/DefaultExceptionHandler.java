package com.movietrailers.exceptions;

import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.movietrailers.jsonsupport.ErrorMessage;

@ControllerAdvice
public class DefaultExceptionHandler {
	
	@Autowired
	ErrorMessage errorMessage;
		
	@ExceptionHandler({MismatchedException.class})
	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
	@ResponseBody
	public ErrorMessage handeResourceNotFoundHandler(MismatchedException exception){
		errorMessage.setErrorCode(422);
		errorMessage.setErrorMessage(exception.getMessage());
		return errorMessage;
	}
	
	@ExceptionHandler({NoHandlerFoundException.class})
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public ErrorMessage handeResourceNotFoundHandler(NoHandlerFoundException exception){
		errorMessage.setErrorCode(404);
		errorMessage.setErrorMessage(exception.getMessage());
		return errorMessage;
	}
	
	@ExceptionHandler(MissingServletRequestParameterException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorMessage handleMissingParameters(MissingServletRequestParameterException exception) {
	    String parameterName = exception.getParameterName();
		errorMessage.setErrorCode(400);
		errorMessage.setErrorMessage(parameterName + " parameter is missing");
		return errorMessage;
	}
	
	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
    public ErrorMessage handle(RuntimeException exception){
		errorMessage.setErrorCode(500);
		errorMessage.setErrorMessage(exception.getMessage());
		return errorMessage;
    }
}
