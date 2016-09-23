
package de.comdirect.collabothon2016.rating.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
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
		group.put(new Nutzer(10L, 0L, "Gabi"), new GroupScore(70));
		group.put(new Nutzer(11L, 0L, "Wilhelm"), new GroupScore(60));
		
		//Group 2.
		Map<Nutzer, GroupScore> group2 = new HashMap<>();
		group2.put(new Nutzer(4L, 100, "Jens"), new GroupScore(100));
		group2.put(new Nutzer(5L, 100, "Jan"), new GroupScore(90));
		group2.put(new Nutzer(6L, 100, "Sasha"), new GroupScore(80));
		//Group 3.
		Map<Nutzer, GroupScore> group3 = new HashMap<>();
		group3.put(new Nutzer(7L, 100, "Bernd"), new GroupScore(100));
		group3.put(new Nutzer(8L, 100, "Moritz"), new GroupScore(90));
		group3.put(new Nutzer(9L, 100, "Sager"), new GroupScore(80));
		

		String infoGroup1 = "Let's go for Tesla, Netflix and Facebook";
		String infoGroup2 = "Let's have real impact with our investment - for us and following generations";
		String infoGroup3 = "We invest in the global fashion business";

		groups.add(new Group(1,"New Technology Club", infoGroup1, group, "monthly", 100, "7d 18h", "2016-03-13", 400));
		groups.add(new Group(2,"Renewable Energies",infoGroup2, group2, "weekly", "5d 18h", "2016-02-17"));
		groups.add(new Group(3,"Fashion & Luxury Goods", infoGroup3, group3, "monthly", "27d 18h", "2016-05-27"));
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Group>> getGroups(){
		return new ResponseEntity<>(groups, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/{groupId}/users")
	public ResponseEntity<List<Nutzer>> getUsersForGroup(@PathVariable(value="groupId") int groupId){
		return new ResponseEntity<List<Nutzer>>(groups.get(groupId-1).getUser(), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/join/{groupId}/{userId}")
	public void joinGroup(@PathVariable(value="groupId") int groupId,@PathVariable(value="userId") int userId){	
//		Map<Nutzer,GroupScore> usersScores = groups.get(groupId-1).getUser();
//		usersScores.put(new Nutzer(userId, 0L, "Test"), new GroupScore(0L));
	}
}

