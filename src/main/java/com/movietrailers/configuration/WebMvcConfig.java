package com.movietrailers.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.http.MediaType;

import com.movietrailers.models.ErrorMessage;
import com.movietrailers.models.OptionalSearchFilter;
import com.movietrailers.services.TmdbService;
import com.movietrailers.services.YouTubeService;



@Configuration
@EnableWebMvc
@ComponentScan ({"com.movietrailers.controllers","com.movietrailers.exceptions"})
public class WebMvcConfig implements WebMvcConfigurer {
	
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {	
	    configurer.favorPathExtension(true).
	    favorParameter(false).
	    ignoreAcceptHeader(true).
	    defaultContentType(MediaType.APPLICATION_JSON); 
	  }
	
	@Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
	
	@Bean
	public YouTubeService getYouTubeClient() {
		return new YouTubeService();
	}
	
	@Bean
	public TmdbService getTmdbClient() {
		return new TmdbService();
	}
		
	@Bean
	public ErrorMessage getErrorMessage() {
		return new ErrorMessage();
	}
	
	@Bean
	public OptionalSearchFilter getOptionalSearchFilter() {
		return new OptionalSearchFilter();
	}
}