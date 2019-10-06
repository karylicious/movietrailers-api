package com.movietrailers.stubs;

import org.springframework.web.client.RestTemplate;

import com.movietrailers.jsonsupport.Genre;
import com.movietrailers.jsonsupport.MovieFullVersion;
import com.movietrailers.jsonsupport.TmdbGenreList;
import com.movietrailers.jsonsupport.TmdbPageMovieList;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/* This class is used as a client stub which will consume TMDB API 
 * 
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

public final class TmdbClient {

	private final static String TMDB_API_URL = "https://api.themoviedb.org/3";
	private final static String TMDB_API_KEY = "60e6f0cf0d843f550667a5ed1ac36671";	
	
	@Autowired
	private RestTemplate restTemplate;
	
	public TmdbPageMovieList getMoviesByTitle(String movieTitle) {
		String requestURL = getFormattedURLForSimpleSearch(movieTitle);
		
		// The RestTemplate retrieves the resource by sending a HTTP GET request and unmarshals it into the class Movie		
		return  restTemplate.getForObject(requestURL, TmdbPageMovieList.class);
	}
	
	public TmdbPageMovieList getMoviesByOptionalFilters(String concatenatedOptionalFilters) {		
		String requestURL = getFormattedURLForAdvancedSearch(concatenatedOptionalFilters);	
		
		// The RestTemplate retrieves the resource by sending a HTTP GET request and unmarshals it into the class Movie		
		return  restTemplate.getForObject(requestURL, TmdbPageMovieList.class);		
	}
	
	public List<Genre> getGenres() {		
		String requestURL = getFormattedURLForGenres();	
		
		// The RestTemplate retrieves the resource by sending a HTTP GET request and unmarshals it into the class YouTubeResult		
		TmdbGenreList listOfGenres = restTemplate.getForObject(requestURL, TmdbGenreList.class);		
		
		return listOfGenres.getListOfGenres();
	}
	
	public MovieFullVersion getMovieById(int movieId) {
		String requestURL = getFormattedURLForMovieDetails(movieId);	
	
		// The RestTemplate retrieves the resource by sending a HTTP GET request and unmarshals it into the class Movie		
		return restTemplate.getForObject(requestURL, MovieFullVersion.class);	
	}
	
	private String getFormattedURLForSimpleSearch(String queryTerm) {		
		String formattedQueryTerm = queryTerm.replace(' ','+'); 	
		return TMDB_API_URL + "/search/movie?query=" + formattedQueryTerm + "&api_key=" + TMDB_API_KEY;
	}	
	
	private String getFormattedURLForAdvancedSearch(String queryTerm) {	
		return TMDB_API_URL + "/discover/movie?" + queryTerm + "&api_key=" + TMDB_API_KEY;
	}	
	
	private String getFormattedURLForGenres() {			
		return TMDB_API_URL + "/genre/movie/list?api_key=" + TMDB_API_KEY;
	}
	
	private String getFormattedURLForMovieDetails(int id) {		
		return TMDB_API_URL + "/movie/" +id+ "?api_key=" + TMDB_API_KEY;
	}	
}