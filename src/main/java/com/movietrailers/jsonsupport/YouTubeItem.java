package com.movietrailers.jsonsupport;

import java.util.Map;
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

public final class YouTubeItem {
	
	@JsonProperty("id")
	private Map<String, String> itemId;
	
	public Map<String, String> getItemId() {
		return itemId;
	}	
}