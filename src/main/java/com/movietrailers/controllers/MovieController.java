package com.movietrailers.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.movietrailers.exceptions.NotFound;
import com.movietrailers.handlers.RequestHandler;

// CORS access control headers (without this the client won't be able to access the response from this web service)
@CrossOrigin(origins = "*") 
@RestController
public final class MovieController {
		
	@Autowired
	RequestHandler requestHandler;
	
	@RequestMapping( path = "/api/v1/movies", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getMoviesByTitle  ( @RequestParam String title) throws Exception{ 
		throw new NotFound("olaaa");
		//return requestHandler.getMoviesByTitleFromTmdbAPIandMarshallIt(title);
		
		
		
		
		//System.out.println(title);
		
		//tmdbClient.getMoviesByTitle(title);
		//String id = youTubeClient.getMovieTrailerIDFromYouTubeAPI(title);
		
		//return "";
		//try {			

			
			//return convertStringToJson("{\"succeed\": " + true + ", \"Info\": \"File uploaded successfully\", \"d\": " + userTemporaryDirectoryName + "}");
		//}
		//catch(Exception exception) {
		//	exception.printStackTrace();			
		//}
		//return convertStringToJson("{\"succeed\": " + false + ", \"Info\": \"File not uploaded\"}");
	}
	
	@RequestMapping(path = "/api/v1/movies/search", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getMoviesByOptionalFilters(@RequestParam(value = "primary_release_year", required=false) String releaseYear,
									@RequestParam(value = "with_genres", required=false) String genres[],
									@RequestParam(value = "vote_average.gte", required=false) String rateGreaterOrEqual,
									@RequestParam(value = "vote_average.lte", required=false) String rateLessOrEqual) {
		
		return requestHandler.getMoviesByOptionalFiltersFromTmdbAPIandMarshallIt("primary_release_year="+releaseYear);		
	}
	
	@RequestMapping(value = "/api/v1/movies/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getMovieById(@PathVariable int  id) {		
		return requestHandler.getMovieByIdFromTmbdAPIAndTrailerIdFromYoutubeAPIAndMarshallIt(id);
	}
	
	
	private String convertStringToJson(String theString){
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