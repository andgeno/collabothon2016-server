package de.comdirect.collabothon2016.rating.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.comdirect.collabothon2016.rating.data.Group;
import de.comdirect.collabothon2016.rating.data.GroupScore;
import de.comdirect.collabothon2016.rating.data.Nutzer;
import de.comdirect.collabothon2016.rating.repo.UserRepository;

@RestController
@RequestMapping(path="/groups/")
public class UserController {
	@Autowired
	private UserRepository repo;

	public static List<Group> groups;
	{	
		groups = new ArrayList<>();
		//Group 1.
		Map<Nutzer, GroupScore> group = new HashMap<>();
		group.put(new Nutzer(1L, 100L, "Terminator"), new GroupScore(100));
		group.put(new Nutzer(2L, 100L, "Walter"), new GroupScore(90));
		group.put(new Nutzer(3L, 100L, "Vader"), new GroupScore(80));
//		//Group 2.
//		Map<Nutzer, GroupScore> group2 = new HashMap<>();
//		group2.put(new Nutzer(4, 100), new GroupScore(100));
//		group2.put(new Nutzer(5, 100), new GroupScore(90));
//		group2.put(new Nutzer(6, 100), new GroupScore(80));
//		//Group 3.
//		Map<Nutzer, GroupScore> group3 = new HashMap<>();
//		group3.put(new Nutzer(7, 100), new GroupScore(100));
//		group3.put(new Nutzer(8, 100), new GroupScore(90));
//		group3.put(new Nutzer(9, 100), new GroupScore(80));
		
		groups.add(new Group(1,"The Great Investor Collective", group, "m", 100, "7d 18h 35m 14s", "2016-03-17", 400));
//		groups.add(new Group(2, group2));
//		groups.add(new Group(3, group3));
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Group>> getGroups(){
		return new ResponseEntity<>(groups, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/join/{groupId}/{userId}")
	public void joinGroup(@PathVariable(value="groupId") int groupId,@PathVariable(value="userId") int userId){	
//		Map<Nutzer,GroupScore> usersScores = groups.get(groupId-1).getUser();
//		usersScores.put(new Nutzer(userId, 0L, "Test"), new GroupScore(0L));
	}
}
