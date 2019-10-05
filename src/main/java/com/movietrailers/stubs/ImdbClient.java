package com.movietrailers.stubs;

import org.springframework.web.client.RestTemplate;

import com.movietrailers.models.Movie;

import org.springframework.beans.factory.annotation.Autowired;
public class ImdbClient {

	@Autowired
	private RestTemplate restTemplate;
	
	public void getMoviesByTitle() {
		//RestTemplate restTemplate = new RestTemplate();
		Movie movie = restTemplate.getForObject("https://gturnquist-quoters.cfapps.io/api/random", Movie.class);
        //log.info(quote.toString());
	}
}
