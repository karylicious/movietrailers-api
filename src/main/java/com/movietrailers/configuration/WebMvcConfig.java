package com.movietrailers.configuration;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.movietrailers.handlers.RequestHandler;
import com.movietrailers.stubs.TmdbClient;
import com.movietrailers.stubs.YouTubeClient;

@Configuration
@EnableWebMvc
@ComponentScan ({"com.movietrailers.controllers","com.movietrailers.exceptions"})
public class WebMvcConfig implements WebMvcConfigurer {
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
	    configurer.favorPathExtension(false).
	            favorParameter(true).
	            parameterName("mediaType").
	            ignoreAcceptHeader(true).
	            useJaf(false).
	            defaultContentType(MediaType.APPLICATION_JSON).
	            mediaType("xml", MediaType.APPLICATION_XML).
	            mediaType("json", MediaType.APPLICATION_JSON);
	  }
	
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
	
	@Bean
	public RequestHandler getRequestHandler() {
		return new RequestHandler();
	}
}