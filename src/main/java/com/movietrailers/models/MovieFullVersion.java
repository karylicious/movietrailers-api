package com.movietrailers.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class MovieFullVersion {
	
	@JsonProperty("id")
	private int id;

	private String title;
	
	@JsonProperty("overview")
	private String overview;

	@JsonProperty("release_date")
	private String releaseDate;
	
	@JsonProperty("vote_average")
	private double rate;	
	
	@JsonProperty("genres")
	private List<Genre> genres;
	
	@JsonProperty("poster_path")
	private String posterPath;
	
	@JsonProperty("trailer_id")
	private String trailerId;
	
	public String getTitle() {
		return title;
	}
	
	public void setTrailerId(String trailerId) {
		this.trailerId = trailerId;
	}	
}