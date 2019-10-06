package com.movietrailers.handlers;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moviestrailers.jsonsupport.Genre;
import com.moviestrailers.jsonsupport.MovieFullVersion;
import com.moviestrailers.jsonsupport.MovieShortVersion;

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
	
	public static String convertListOfMoviesToJSON(List<MovieShortVersion> listOfMovies) {
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
	
	
	private String convertStringToJsonsss(String theString){
		try {
			ObjectMapper mapper = new ObjectMapper();
			Object jsonObject = mapper.readValue(theString, Object.class);
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonObject);
		}
		catch(Exception exception) {
			exception.printStackTrace();
		}
		return "";
	}
	
	
	
}
