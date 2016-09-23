package de.comdirect.collabothon2016.voting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.PropertyBatchUpdateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.comdirect.collabothon2016.data.InvestmentSuggestion;


@RestController
public class VotingControler {


	   private HashMap<Long,List<InvestmentSuggestion>> suggestions = Fallback.getInvestmentSuggestion();
	
	   @RequestMapping(method=RequestMethod.GET, path="/voting/suggestions/group/{groupid}")
	   public ResponseEntity<List<InvestmentSuggestion>> getInvestmentSuggestion(@PathVariable(value="groupid") long groupid)
	   {  
			return new ResponseEntity<List<InvestmentSuggestion>>(suggestions.get(groupid), HttpStatus.ACCEPTED);
	   }
	   
	   @RequestMapping(method=RequestMethod.POST, path="/voting/suggestions/group/add")
	   public ResponseEntity addSuggestion(@RequestParam(value="groupid") long groupid, @RequestParam(value="userId") long userId, @RequestParam(value="comment") String comment, @RequestParam(value="title") String title)
	   {
		   InvestmentSuggestion investmentSuggestion = new InvestmentSuggestion();
		   investmentSuggestion.setTitle(title);
		   investmentSuggestion.setUserId(userId);
		   investmentSuggestion.setComment(comment);
		   
		   suggestions.get(groupid).add(investmentSuggestion);
		  	   
		  return new ResponseEntity( HttpStatus.ACCEPTED);
	   }
}
