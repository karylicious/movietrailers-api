package com.moviestrailers.jsonsupport;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * This class is used to support JSON deserialization
 * 
 * The @JsonProperty annotation is used to map property names with JSON keys
 * during serialization and deserialization. 
 * 
 * This annotation is used during deserialization when the property names of the JSON
 * and the field names of the Java object do not match. 
 */

public final class TmdbSingleMovie{		
	
	@JsonProperty("results")
	private List<MovieShortVersion> tmdbSingleMovie;
	
	public List<MovieShortVersion> getTmdbSingleMovie() {
		return tmdbSingleMovie;
	}
}