package ch.abbaye11.rest;

import com.google.gson.Gson;

public class RestTest {
	
	private String test;
	
	
	public RestTest(String test){
		this.test = test;
	}
	
	public String toJson(){
		Gson gson = new Gson();
		return gson.toJson(this);
	}

}
