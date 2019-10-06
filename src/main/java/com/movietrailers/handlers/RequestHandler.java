package com.movietrailers.handlers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.moviestrailers.jsonsupport.Genre;
import com.moviestrailers.jsonsupport.MovieFullVersion;
import com.moviestrailers.jsonsupport.MovieShortVersion;
import com.moviestrailers.jsonsupport.TmdbPageMovieList;
import com.movietrailers.stubs.TmdbClient;
import com.movietrailers.stubs.YouTubeClient;

// This class is used to retrieve data from an external API and return it in JSON format

public final class RequestHandler {

	@Autowired
	private TmdbClient tmdbClient;
	
	@Autowired
	private YouTubeClient youTubeClient;
	
	public String getGenresFromTmdbAPIandMarshallIt() {
		List<Genre> listOfGenres = tmdbClient.getGenres();
		return MarshallingHandler.convertListOfGenresToJSON(listOfGenres);
	}
	
	public String getMoviesByTitleFromTmdbAPIandMarshallIt(String movieTitle) {
		TmdbPageMovieList listOfMovies = tmdbClient.getMoviesByTitle(movieTitle);		
		return MarshallingHandler.convertListOfMoviesToJSON(listOfMovies);
	}
	
	public String getMoviesByOptionalFiltersFromTmdbAPIandMarshallIt(String concatenatedOptionalFilters) {
		TmdbPageMovieList listOfMovies = tmdbClient.getMoviesByOptionalFilters(concatenatedOptionalFilters);
		return MarshallingHandler.convertListOfMoviesToJSON(listOfMovies);
	}
	
	public String getMovieByIdFromTmbdAPIAndTrailerIdFromYoutubeAPIAndMarshallIt(int movieId) {
		MovieFullVersion movie = tmdbClient.getMovieById(movieId);
		String trailerId = youTubeClient.getMovieTrailerIDFromYouTubeAPI(movie.getTitle());
		
		movie.setTrailerId(trailerId); // trailerId of movie object is originally null
		return MarshallingHandler.convertMovieToJSON(movie);
	}
}