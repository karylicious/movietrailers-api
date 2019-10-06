package com.moviestrailers.jsonsupport;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * The @JsonProperty annotation is used to map property names with JSON keys
 * during serialization and deserialization. 
 * 
 * This annotation is used during deserialization when the property names of the JSON
 * and the field names of the Java object do not match. 
 */

public class Genre {	
	//@JsonProperty("id")
	private int id;
	//@JsonProperty("name")
	private String name;
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
}
