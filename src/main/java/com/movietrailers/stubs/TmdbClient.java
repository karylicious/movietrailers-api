package com.movietrailers.stubs;

import org.springframework.web.client.RestTemplate;

import com.moviestrailers.jsonsupport.YouTubeResult;
import com.movietrailers.models.Movie;

import org.springframework.beans.factory.annotation.Autowired;

/*
 * To access the Rotten tomatoes data I have to ask for permission 
 * by submitting a proposal form describing how I would use the data, therefore 
 * I decided to go for IMDB API.
 * 
 * However the IMDB has no public API. As an alternative I am using TMDB API that 
 * provides the exact functionality of IMDB.
 * 
 * According to the TMDB API reference every request must specify an API key. 
 * 
 * The API key used by this class was generated after creating an account. 
 * 
 * For more information: https://developers.themoviedb.org/3/getting-started/introduction
 * 
 */

public class TmdbClient {

	private final static String TMDB_API_URL = "https://api.themoviedb.org/3";
	private final static String TMDB_API_KEY = "60e6f0cf0d843f550667a5ed1ac36671";
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	public void getMoviesByTitle() {
		//RestTemplate restTemplate = new RestTemplate();
		Movie movie = restTemplate.getForObject("https://gturnquist-quoters.cfapps.io/api/random", Movie.class);
        //log.info(quote.toString());
	}
	
	public String getMovieTrailerIDFromYouTubeAPI(String movieTitle) {		
		
		String requestURL = getFormattedURL(movieTitle);	
		
		// The RestTemplate retrieves the resource by sending a HTTP GET request and unmarshals it into the class YouTubeResult		
		YouTubeResult youTubeResult = restTemplate.getForObject(requestURL, YouTubeResult.class);			
		
		return getVideoIdFromYouTubeResult(youTubeResult);
	}
	
	private String getFormattedURLForSimpleSearch(String queryTerm) {
		
		String formattedQueryTerm = queryTerm.replace(' ','+'); 	
		return TMDB_API_URL + "/search/movie?" + "query=" + formattedQueryTerm + "&api_key=" + TMDB_API_KEY;
	}	
	
	private String getFormattedURLForAdvancedSearch(String queryTerm) {
		
		String formattedQueryTerm = queryTerm.replace(' ','+');

		return TMDB_API_URL + "/discover/movie?" + "query=" + formattedQueryTerm + "&api_key=" + TMDB_API_KEY;
	}	
	
	private String getFormattedURLForGenres(String queryTerm) {
			
		return TMDB_API_URL + "/genre/movie/list?" + "api_key=" + TMDB_API_KEY;
	}	
	
}
