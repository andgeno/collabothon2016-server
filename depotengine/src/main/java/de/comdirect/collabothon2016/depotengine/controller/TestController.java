package de.comdirect.collabothon2016.depotengine.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.comdirect.collabothon2016.depotengine.data.Test;

@RestController
public class TestController {
	
	@RequestMapping(method=RequestMethod.POST, path="/test")
	public ResponseEntity<Test> testCall(){
		new ResponseEntity<>(new Test(), HttpStatus.OK);
	}
}
