package de.comdirect.collabothon2016.depotengine.controller;

import org.springframework.web.client.RestTemplate;

public class RestClient {
	
	public static String askRating(){
        RestTemplate restTemplate = new RestTemplate();
        Long rating = restTemplate.getForObject("http://localhost:8090/users/rank/123", Long.class);
        return ("Hey I am a Restclient and i called Rating" + rating);
	}
}
