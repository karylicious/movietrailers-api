package com.movietrailers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.movietrailers.handlers.RequestHandler;

// CORS access control headers (without this the client won't be able to access the response from this web service)
@CrossOrigin(origins = "*") 
@RestController
public final class GenreController {
		
	@Autowired
	private RequestHandler requestHandler;
		
	@RequestMapping(path = "/api/v1/genres", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getGenres() {
		return requestHandler.getGenresFromTmdbAPIandMarshallIt();
	}	
}