package com.movietrailers.stubs;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.moviestrailers.jsonsupport.YouTubeItem;
import com.moviestrailers.jsonsupport.YouTubeResult;

/*
 * According to the YouTube Data API reference  every request must either 
 * specify an API key  (with the key parameter) or provide an OAuth 2.0 token. 
 * 
 * This class uses the API key, which was generated at the  API library.
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
		
		String requestURL = getFormattedURL(movieTitle);	
		
		// The RestTemplate retrieves the resource by sending a HTTP GET request and unmarshals it into the class YouTubeResult		
		YouTubeResult youTubeResult = restTemplate.getForObject(requestURL, YouTubeResult.class);			
		
		return getVideoIdFromYouTubeResult(youTubeResult);
	}
	
	private String getFormattedURL(String queryTerm) {
		
		String formattedQueryTerm = queryTerm.replace(' ','+');
		formattedQueryTerm += "+trailer"; 		
		int maxResults = 1;
		
		return YOUTUBE_API_URL + "?" + "q=" + formattedQueryTerm + "&part=snippet&type=video&videoEmbeddable=true&maxResults=" + maxResults + "&key=" + YOUTUBE_DATA_API_KEY;
	}	
	
	private String getVideoIdFromYouTubeResult(YouTubeResult youTubeResult) {
		
		YouTubeItem firstItem = youTubeResult.getYouTubeItemsList().get(0);
		Map<String, String> youtubeItemId = firstItem.getItemId();
		
		// The key "videoId" comes from a property name of the JSON response
		return youtubeItemId.get("videoId");
	}
}