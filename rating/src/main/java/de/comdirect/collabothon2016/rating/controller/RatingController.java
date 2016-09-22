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

import de.comdirect.collabothon2016.rating.data.Group;
import de.comdirect.collabothon2016.rating.data.GroupScore;
import de.comdirect.collabothon2016.rating.data.Nutzer;
import de.comdirect.collabothon2016.rating.repo.UserRepository;

@RestController
@RequestMapping(path="/rating")
public class RatingController {
	@Autowired
	private UserRepository repo;
	
	@RequestMapping(method=RequestMethod.GET, path="/user/{id}")
	public ResponseEntity<Long> getRating(@PathVariable(value="id")long userId){
		//repo.getUser(userId);//.getScore;
		System.out.println("user for number " + userId);
		return new ResponseEntity<Long>(userId, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/groups/rank/{groupId}")
	public ResponseEntity<Group> getGroupRatings(@PathVariable(value="groupId")int groupId){
		
		return new ResponseEntity<>(UserController.groups.get(groupId+1), HttpStatus.OK);
	}
}
