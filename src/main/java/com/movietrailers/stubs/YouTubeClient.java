package com.movietrailers.stubs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.movietrailers.models.YouTubeVideo;

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
	
	// Make the HTTP POST request, marshaling the request to JSON, and the response to a 
	public String getMovieTrailerIDFromYouTubeAPI(String movieTitle) {
		String requestURL = buildURL(movieTitle);
		
		//Object[] obj = restTemplate.getForObject(requestURL, Object[].class);
		//System.out.println(restTemplate.getForObject(requestURL, YouTubeVideo.class));
		//System.out.println(requestURL);
		//return "";
		YouTubeVideo video = restTemplate.getForObject(requestURL, YouTubeVideo.class);	
		System.out.println(video.getMylist().get(0).getId().get("videoId"));
		return "";//video.getMylist().get(0).getId();
	}
	
	private String buildURL(String queryTerm) {
		String formattedQueryTerm = queryTerm.replace(' ','+');
		return YOUTUBE_API_URL + "?" + "q=" + formattedQueryTerm + "&part=snippet&type=video&videoEmbeddable=true&maxResults=1&key=" + YOUTUBE_DATA_API_KEY;
	}	
}