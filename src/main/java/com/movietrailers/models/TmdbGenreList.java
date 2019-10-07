package com.movietrailers.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class TmdbGenreList{		
	
	@JsonProperty("genres")
	private List<Genre> listOfGenres;
	
	public List<Genre> getListOfGenres() {
		return listOfGenres;
	}
}