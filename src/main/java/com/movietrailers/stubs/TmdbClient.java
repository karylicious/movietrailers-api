package com.movietrailers.stubs;

import org.springframework.web.client.RestTemplate;

import com.movietrailers.models.Genre;
import com.movietrailers.models.MovieFullVersion;
import com.movietrailers.models.OptionalSearchFilter;
import com.movietrailers.models.TmdbGenreList;
import com.movietrailers.models.TmdbPageMovieList;

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
		return  restTemplate.getForObject(requestURL, TmdbPageMovieList.class);
	}
	
	public TmdbPageMovieList getMoviesByOptionalFilters(OptionalSearchFilter optionalSearchFilters) {		
		String concatenatedOptionalFilters = getConcatenatedNonEmptyFilter(optionalSearchFilters);
		
		if(concatenatedOptionalFilters.equals(""))
			return new TmdbPageMovieList();
		
		String requestURL = getFormattedURLForAdvancedSearch(concatenatedOptionalFilters);	
		return  restTemplate.getForObject(requestURL, TmdbPageMovieList.class);		
	}
	
	public List<Genre> getGenres() {		
		String requestURL = getFormattedURLForGenres();				
		TmdbGenreList listOfGenres = restTemplate.getForObject(requestURL, TmdbGenreList.class);	
		return listOfGenres.getListOfGenres();
	}
	
	public MovieFullVersion getMovieById(int movieId) {
		String requestURL = getFormattedURLForMovieDetails(movieId);			
		return restTemplate.getForObject(requestURL, MovieFullVersion.class);	
	}
	
	private String getConcatenatedNonEmptyFilter(OptionalSearchFilter optionalSearchFilters) {
		String concatenatedFilters = "";
		String genreIds = optionalSearchFilters.getGenreIds();
		
		if (genreIds != null) {
			concatenatedFilters += (concatenatedFilters.equals("") ? "with_genres=": "&with_genres=");
			concatenatedFilters += genreIds;
		}
				  
		String releseYear = optionalSearchFilters.getReleaseYear();
		if(releseYear != null) {
			concatenatedFilters += (concatenatedFilters.equals("") ? "primary_release_year=": "&primary_release_year=");
			concatenatedFilters += releseYear;
		}		
	
		String rateGreaterOrEqual = optionalSearchFilters.getRateGreaterOrEqual();
		
		if(rateGreaterOrEqual != null){
			concatenatedFilters += (concatenatedFilters.equals("") ? "vote_average.gte=": "&vote_average.gte=");
			concatenatedFilters += rateGreaterOrEqual;
		}
					
		String rateLessOrEqual = optionalSearchFilters.getRateLessOrEqual();
		
		if(rateGreaterOrEqual != null){
			concatenatedFilters += (concatenatedFilters.equals("") ? "vote_average.lte=": "&vote_average.lte=");
			concatenatedFilters += rateLessOrEqual;
		}			
		
		return concatenatedFilters;
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