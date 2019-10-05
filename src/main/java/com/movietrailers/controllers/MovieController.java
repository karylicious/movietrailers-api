package com.movietrailers.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.movietrailers.stubs.YouTubeClient;

@CrossOrigin(origins = "*") // CORS access control headers (without this the client won't be able to access the response from this web service)
@RestController
public class MovieController {
	
	@Autowired
	private YouTubeClient youTubeClient;
	
	@RequestMapping( path = "/api/v1/movies", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getMovieByTitle  ( @RequestParam String title) { 
		return youTubeClient.getMovieTrailerIDFromYouTubeAPI(title);
		//try {			

			
			//return convertStringToJson("{\"succeed\": " + true + ", \"Info\": \"File uploaded successfully\", \"d\": " + userTemporaryDirectoryName + "}");
		//}
		//catch(Exception exception) {
		//	exception.printStackTrace();			
		//}
		//return convertStringToJson("{\"succeed\": " + false + ", \"Info\": \"File not uploaded\"}");
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
