package com.movietrailers.handlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.movietrailers.exceptions.NotFound;
import com.movietrailers.jsonsupport.Genre;
import com.movietrailers.jsonsupport.MovieFullVersion;
import com.movietrailers.jsonsupport.TmdbPageMovieList;
import com.movietrailers.stubs.TmdbClient;
import com.movietrailers.stubs.YouTubeClient;

// This class is used to retrieve data from an external API and return it in JSON format

public final class RequestHandler {

	@Autowired
	private TmdbClient tmdbClient;
	
	@Autowired
	private YouTubeClient youTubeClient;
	
	//public String getGenres() {
		
	//}
	
	public String getGenresFromTmdbAPIandMarshallIt() {
		List<Genre> listOfGenres = tmdbClient.getGenres();
		return MarshallingHandler.convertListOfGenresToJSON(listOfGenres);
	}
	
	public String getMoviesByTitleFromTmdbAPIandMarshallIt(String movieTitle) throws Exception{
		throw new NotFound("olaaa");
		//TmdbPageMovieList listOfMovies = tmdbClient.getMoviesByTitle(movieTitle);		
		//return MarshallingHandler.convertListOfMoviesToJSON(listOfMovies);
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