package de.comdirect.collabothon2016.voting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.PropertyBatchUpdateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.comdirect.collabothon2016.data.InvestmentSuggestion;
import de.comdirect.collabothon2016.data.LeaderBoardEntry;
import de.comdirect.collabothon2016.data.Voting;


@RestController
public class VotingControler {
		 
       private HashMap<Long,List<LeaderBoardEntry>> leaderBoard = Fallback.getLeaderBoard();
	   private HashMap<Long,List<InvestmentSuggestion>> suggestions = Fallback.getInvestmentSuggestion();
	   private Map<Long, Voting> votings = new HashMap<>();
	   
	   @RequestMapping(method=RequestMethod.POST, path="/voting/active/{groupid}")
	   public ResponseEntity<Void> activateVoting(@PathVariable(value="groupid") long groupId){
		   
		   Voting voting = votings.get(groupId);
		   if (voting==null){
			   return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		   }
		   
		   if (!voting.isWaitingVorContracts() || voting.isActive()){
			   return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
		   }
		   
		   voting.setActive(true);
		   voting.setWaitingVorContracts(false);
		   return new ResponseEntity<>(HttpStatus.OK);
	   }
	
		@RequestMapping(method=RequestMethod.GET, path="/user/{id}")
		public ResponseEntity<Long> getRating(@PathVariable(value="id")long userId){
			//repo.getUser(userId);//.getScore;
			System.out.println("user for number " + userId);
			return new ResponseEntity<Long>(userId, HttpStatus.OK);
		}
	   
	   
	   @RequestMapping(method=RequestMethod.GET, path="/voting/suggestions/group/{groupid}")
	   public ResponseEntity<List<InvestmentSuggestion>> getInvestmentSuggestion(@PathVariable(value="groupid") long groupid)
	   {  
			return new ResponseEntity<List<InvestmentSuggestion>>(suggestions.get(groupid), HttpStatus.ACCEPTED);
	   }
	   
	   @RequestMapping(method=RequestMethod.GET, path="/voting/leaderboard/group/{groupid}")
	   public ResponseEntity<List<LeaderBoardEntry>> getLeaderboard(@PathVariable(value="groupid") long groupid)
	   {  
			return new ResponseEntity<List<LeaderBoardEntry>>(leaderBoard.get(0L), HttpStatus.ACCEPTED);
	   }
	   
	   
	   @RequestMapping(method=RequestMethod.PUT, path="/voting/vote/{groupid}/{suggestIndex}")
	   public ResponseEntity<Long> addVote(@RequestParam(value="groupid") long groupid,@RequestParam(value="indexInVode") int indexInVote){
		   Voting voting = votings.get(groupid);
		   InvestmentSuggestion investmentSuggestion = null;
		   if (voting != null){
			   if (indexInVote >=0 && indexInVote < suggestions.get(groupid).size()){
			   investmentSuggestion = suggestions.get(groupid).get(indexInVote);
			   if (investmentSuggestion != null){
				   investmentSuggestion.addVote();
			   }
			   }
		   }
		   
		   if (voting == null || investmentSuggestion == null){
			   return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		   }else{
			   return new ResponseEntity<Long>(investmentSuggestion.getVotes()-1, HttpStatus.OK);
		   }
		   
	   }
	   
	   @RequestMapping(method=RequestMethod.POST, path="/voting/suggestion/group/{groupid}/user/{userId}")
	   public ResponseEntity<Integer> addSuggestion(@RequestParam(value="groupid") long groupid, @RequestParam(value="userId") long userId, @RequestParam(value="comment") String comment, @RequestParam(value="title") String title, @RequestParam(value="wertpapier") String wertpapier)
	   {
		   InvestmentSuggestion investmentSuggestion = new InvestmentSuggestion();
		   investmentSuggestion.setTitle(title);
		   investmentSuggestion.setUserId(userId);
		   investmentSuggestion.setComment(comment);
		   investmentSuggestion.setWertpapier(wertpapier);
		   
		   suggestions.get(groupid).add(investmentSuggestion);
		  	   
		  return new ResponseEntity(suggestions.get(groupid).size()-1, HttpStatus.ACCEPTED);
	   }
	   
	   @RequestMapping(method=RequestMethod.GET, path = "/voting/suggestions/winner/{groupid}")
	   public ResponseEntity<List<InvestmentSuggestion>> getVotingWinner(@RequestParam(value="groupid") long groupId, @RequestParam(value="") int upToPosition){
		   
		return new ResponseEntity<List<InvestmentSuggestion>>(HttpStatus.METHOD_FAILURE);   
	   }
}

