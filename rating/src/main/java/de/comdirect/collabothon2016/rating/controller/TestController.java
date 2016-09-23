package de.comdirect.collabothon2016.rating.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import de.comdirect.collabothon2016.rating.data.TestString;

@RestController
public class TestController {
	
	@RequestMapping(method=RequestMethod.POST, path="/test")
	public ResponseEntity<TestString> testCall(){
		return new ResponseEntity<TestString>(new TestString("info"), HttpStatus.OK);
	}
}
