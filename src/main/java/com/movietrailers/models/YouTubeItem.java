package com.movietrailers.models;

import java.util.List;
import java.util.Map;

public class YouTubeItem {
	private String kind;
	private String etag;
	//private List<String> id;
	private Map<String, String> id;
	public Map<String, String> getId() {
		return id;
	}
	public void setId(Map<String, String> id) {
		this.id = id;
	}
	
	
}
