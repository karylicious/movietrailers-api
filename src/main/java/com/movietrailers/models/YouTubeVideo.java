package com.movietrailers.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class YouTubeVideo{
	
	
	
	@JsonProperty("items")
	 private List<YouTubeItem> mylist = new ArrayList<YouTubeItem>();
	
	
	
	
	/*//@JsonProperty("title")
	private String title;
	//@JsonProperty("videoId")
	private String videoId;

	public YouTubeVideo () {
	}
	public YouTubeVideo (String title, String videoId) {
		this.title = title;
		this.videoId = videoId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getVideoId() {
		return videoId;
	}*/


	public List<YouTubeItem> getMylist() {
		return mylist;
	}


	public void setMylist(List<YouTubeItem> mylist) {
		this.mylist = mylist;
	}
}
