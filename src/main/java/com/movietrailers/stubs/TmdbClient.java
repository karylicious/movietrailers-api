package com.movietrailers.stubs;

import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.moviestrailers.jsonsupport.Genre;
import com.moviestrailers.jsonsupport.GenreList;
import com.moviestrailers.jsonsupport.MovieFullVersion;
import com.moviestrailers.jsonsupport.MovieShortVersion;
import com.moviestrailers.jsonsupport.TmdbMovieList;

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
	
	public List<MovieShortVersion> getMoviesByTitle(String movieTitle) {
		String requestURL = getFormattedURLForSimpleSearch(movieTitle);
		return getMovieListFromTmdbAPI(requestURL);	
	}
	
	public List<MovieShortVersion> getMoviesByOptionalFilters(String concatenatedOptionalFilters) {		
		String requestURL = getFormattedURLForAdvancedSearch(concatenatedOptionalFilters);	
		return getMovieListFromTmdbAPI(requestURL);			
	}
	
	public List<Genre> getGenres() {		
		String requestURL = getFormattedURLForGenres();	
		
		// The RestTemplate retrieves the resource by sending a HTTP GET request and unmarshals it into the class YouTubeResult		
		GenreList listOfGenres = restTemplate.getForObject(requestURL, GenreList.class);		
		
		return listOfGenres.getListOfGenres();
	}
	
	public MovieFullVersion getMovieById(int movieId) {
		String requestURL = getFormattedURLForMovieDetails(movieId);	
	
		// The RestTemplate retrieves the resource by sending a HTTP GET request and unmarshals it into the class Movie		
		return restTemplate.getForObject(requestURL, MovieFullVersion.class);	
	}

	private List<MovieShortVersion> getMovieListFromTmdbAPI(String requestURL){
		// The RestTemplate retrieves the resource by sending a HTTP GET request and unmarshals it into the class Movie		
		TmdbMovieList list = restTemplate.getForObject(requestURL, TmdbMovieList.class);		
		return list.getTmdbResultList();
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