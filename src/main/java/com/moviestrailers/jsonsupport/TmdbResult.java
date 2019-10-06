package com.moviestrailers.jsonsupport;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * The @JsonProperty annotation is used to map property names with JSON keys
 * during serialization and deserialization. 
 * 
 * This annotation is used during deserialization when the property names of the JSON
 * and the field names of the Java object do not match. 
 */

public class TmdbResult{		
	
	@JsonProperty("results")
	private List<Movie> tmdbResultList;
	
	public List<Movie> getTmdbResultList() {
		return tmdbResultList;
	}
}