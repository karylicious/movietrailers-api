package com.movietrailers.handlers;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.movietrailers.jsonsupport.Genre;
import com.movietrailers.jsonsupport.MovieFullVersion;
import com.movietrailers.jsonsupport.TmdbPageMovieList;

// This class is used to  handle the process of transforming data into JSON format

public final class MarshallingHandler {

	public static String convertListOfGenresToJSON(List<Genre> listOfGenres) {
		return convertObjectToJson(listOfGenres);
		//ObjectMapper mapper = new ObjectMapper();
		
		//return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(listOfGenres);
		/*
		for (Genre currentGenre : listOfGenres){
			convertStringToJson("{\"succeed\": " + true + ", \"Info\": \"File uploaded successfully\", \"d\": " + userTemporaryDirectoryName + "}");
		}
		listOfGenres.get(0).getName()
		list.getListOfGenre().get(0).getId()
		return "";*/
	}
	
	public static String convertListOfMoviesToJSON(TmdbPageMovieList listOfMovies) {
		return convertObjectToJson(listOfMovies);
	}
	
	public static String convertMovieToJSON(MovieFullVersion movie) {
		return convertObjectToJson(movie);
	}
	
	private static String convertObjectToJson(Object objectToBeConverted){
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(objectToBeConverted);
		}
		catch(Exception exception) {
			exception.printStackTrace();
		}
		return null;
	}
}
