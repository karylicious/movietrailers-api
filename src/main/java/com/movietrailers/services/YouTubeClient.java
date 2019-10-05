package com.movietrailers.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.movietrailers.models.Movie;

/*
 * According to YouTube Data API reference
 * every request must must either specify an API key 
 * (with the key parameter) or provide an OAuth 2.0 token. 
 * 
 * This class uses the API key, which was generated at the  API library
 * 
 * For more information: https://developers.google.com/youtube/v3/docs
 * 
 */


public class YouTubeClient {

	private final static String YOUTUBE_API_URL = "https://www.googleapis.com/youtube/v3/search";
	private final static String YOUTUBE_DATA_API_KEY = "AIzaSyBZPWK96Ni0KdePWNN84ADmVLXM1P9iRtg";
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	public String getMovieTrailerIDFromYouTubeAPI(String movieTitle) {
		String requestURL = buildURL(movieTitle);
		Movie movie = restTemplate.getForObject(requestURL, Movie.class);
		return "";
	}
	
	public String buildURL(String queryTerm) {
		String formattedQueryTerm = queryTerm.replace(' ','+');
		return YOUTUBE_API_URL + "?" + "q=" + formattedQueryTerm + "&part=snippet&type=video&videoEmbeddable=true&maxResults=1&key=" + YOUTUBE_DATA_API_KEY;
	}	
}
