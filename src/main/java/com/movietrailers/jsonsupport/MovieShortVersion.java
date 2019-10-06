package com.movietrailers.jsonsupport;

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

public final class MovieShortVersion {	
	
	@JsonProperty("id")
	private int id;

	@JsonProperty("title")
	private String title;
	
	@JsonProperty("poster_path")
	private String posterPath;

	@JsonProperty("release_date")
	private String releaseDate;
}