package de.comdirect.collabothon2016.rating.controller;

import java.util.Map;

import org.apache.coyote.http11.Http11OutputBuffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.comdirect.collabothon2016.rating.data.Score;
import de.comdirect.collabothon2016.rating.data.User;
import de.comdirect.collabothon2016.rating.repo.UserRepository;

@RestController
public class RatingController {
	@Autowired
	private UserRepository repo;
	
	@RequestMapping(method=RequestMethod.GET, path="/users/rank/{id}")
	public ResponseEntity<Long> getRating(@PathVariable(value="id")long userId){
		//repo.getUser(userId);//.getScore;
		System.out.println(userId);
		return new ResponseEntity<Long>(userId, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/groups/rank/{groupId}")
	public ResponseEntity<User> getGroupRatings(@RequestParam(value="groupId")long groupId){
		return null;
	}
}
