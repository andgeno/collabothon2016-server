package de.comdirect.collabothon2016.depotengine.controller;

import org.springframework.web.client.RestTemplate;

public class RestClient {
	
	static String addr="0xfc7bc586b4f3e9c1dfcb4ebaf97dd397f5a2514b";
	
	public static String makePayment(long userId){
        RestTemplate restTemplate = new RestTemplate();
        String address = restTemplate.getForObject("http://172.31.124.69:1337/pay/" + addr, String.class);
//        String address = restTemplate.getForObject("http://127.0.0.1:1337/pay/" + addr, String.class);
        return (address);
	}
	
	public static boolean checkPayment(long userId){
        RestTemplate restTemplate = new RestTemplate();
        boolean check = restTemplate.getForObject("http://172.31.124.69:1337/check/" + addr, Boolean.class); // 172.31.124.69
//        boolean check = restTemplate.getForObject("http://127.0.0.1:1337/check/" + addr, Boolean.class); // 172.31.124.69
        return check;
//        return ("Hey i am calling the Blockchain " + check);
	}
}
