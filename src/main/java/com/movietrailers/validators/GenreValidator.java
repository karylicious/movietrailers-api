package com.movietrailers.validators;

import org.springframework.beans.factory.annotation.Autowired;

import com.movietrailers.handlers.RequestHandler;

public final class GenreValidator {
	@Autowired
	private RequestHandler requestHandler;
	
	public String getGenresWithoutValidating() {
		return requestHandler.getGenresFromTMDBAPIandMarshallIt();		
	}	
}