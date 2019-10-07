package com.movietrailers.models;

import com.fasterxml.jackson.annotation.JsonProperty;

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