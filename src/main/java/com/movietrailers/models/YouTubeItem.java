package com.movietrailers.models;

import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class YouTubeItem {
	
	@JsonProperty("id")
	private Map<String, String> itemId;
	
	public Map<String, String> getItemId() {
		return itemId;
	}	
}