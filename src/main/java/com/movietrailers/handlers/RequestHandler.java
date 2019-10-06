package com.movietrailers.handlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.moviestrailers.jsonsupport.Genre;
import com.movietrailers.stubs.TmdbClient;

public final class RequestHandler {

	@Autowired
	private TmdbClient tmdbClient;
	
	public String getGenresFromTMDBAPIandMarshallIt() {
		List<Genre> listOfGenres = tmdbClient.getGenres();
		return MarshallingHandler.convertListOfGenresToJSON(listOfGenres);
	}
}