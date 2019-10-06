package com.moviestrailers.jsonsupport;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * The @JsonProperty annotation is used to map property names with JSON keys
 * during serialization and deserialization. 
 * 
 * This annotation is used during deserialization when the property names of the JSON
 * and the field names of the Java object do not match. 
 */

public class Movie {
	
	@JsonProperty("id")
	private int id;

	@JsonProperty("title")
	private String title;
	
	@JsonProperty("overview")
	private String overview;

	@JsonProperty("release_date")
	private String releaseDate;
	
	@JsonProperty("vote_average")
	private double rating;	
	
	@JsonProperty("genre_ids")
	private List<Integer> genreIds;

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getOverview() {
		return overview;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public double getRating() {
		return rating;
	}

	public List<Integer> getGenreIds() {
		return genreIds;
	}
}