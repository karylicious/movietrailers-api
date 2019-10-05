package com.movietrailers.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import com.movietrailers.stubs.YouTubeClient;
import com.movietrailers.stubs.TmdbClient;

@Configuration
@ComponentScan ({"com.movietrailers.controllers"})
public class AppConfig {
	
	@Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
	
	@Bean
	public YouTubeClient getYouTubeClient() {
		return new YouTubeClient();
	}
	
	@Bean
	public TmdbClient getTmdbClient() {
		return new TmdbClient();
	}
}