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
import de.comdirect.collabothon2016.data.Voting;


@RestController
public class VotingControler {


	   private HashMap<Long,List<InvestmentSuggestion>> suggestions = Fallback.getInvestmentSuggestion();
	   private Map<Long, Voting> votings = new HashMap<>();
	
	   @RequestMapping(method=RequestMethod.GET, path="/voting/suggestions/group/{groupid}")
	   public ResponseEntity<List<InvestmentSuggestion>> getInvestmentSuggestion(@RequestParam(value="groupid") long groupid)
	   {  
			return new ResponseEntity<List<InvestmentSuggestion>>(suggestions.get(groupid), HttpStatus.ACCEPTED);
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
	   public ResponseEntity<Integer> addSuggestion(@RequestParam(value="groupid") long groupid, @RequestParam(value="userId") long userId, @RequestParam(value="comment") String comment, @RequestParam(value="title") String title)
	   {
		   InvestmentSuggestion investmentSuggestion = new InvestmentSuggestion();
		   investmentSuggestion.setTitle(title);
		   investmentSuggestion.setUserId(userId);
		   investmentSuggestion.setComment(comment);
		   
		   suggestions.get(groupid).add(investmentSuggestion);
		  	   
		  return new ResponseEntity(suggestions.get(groupid).size()-1, HttpStatus.ACCEPTED);
	   }
	   
	   @RequestMapping(method=RequestMethod.GET, path = "/voting/suggestions/winner/{groupid}")
	   public ResponseEntity<List<InvestmentSuggestion>> getVotingWinner(@RequestParam(value="groupid") long groupId, @RequestParam(value="") int upToPosition){
		   
		return new ResponseEntity<List<InvestmentSuggestion>>(HttpStatus.METHOD_FAILURE);   
	   }
}

