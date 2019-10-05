package com.movietrailers.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import com.movietrailers.stubs.YouTubeClient;

@Configuration
@ComponentScan ({"com.movietrailers.controllers"})
public class AppConfig {
	
	@Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
	
	@Bean
    public String getYouTubeUrl() {
        return "http";
    }	
	
	@Bean
	public YouTubeClient getYouTubeClient() {
		return new YouTubeClient();
	}

}
