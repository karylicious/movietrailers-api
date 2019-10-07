package com.movietrailers.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class TmdbSingleMovie{		
	
	@JsonProperty("results")
	private List<MovieShortVersion> tmdbSingleMovie;
	
	public List<MovieShortVersion> getTmdbSingleMovie() {
		return tmdbSingleMovie;
	}
}