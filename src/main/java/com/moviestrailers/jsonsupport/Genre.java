package com.moviestrailers.jsonsupport;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

// This class is used to support JSON deserialization  

public class Genre {	
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
}