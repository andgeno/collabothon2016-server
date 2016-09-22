package de.comdirect.collabothon2016.voting;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.comdirect.collabothon2016.data.InvestmentSuggestion;


@RestController
public class VotingControler {

	
	   @RequestMapping(method=RequestMethod.GET, path="/voting/suggestions/group/{groupid}")
	   public ResponseEntity<List<InvestmentSuggestion>> getInvestmentSuggestion(@PathVariable(value="groupid") long groupid)
	   {
			return new ResponseEntity<List<InvestmentSuggestion>>(Fallback.getInvestmentSuggestion(), HttpStatus.CREATED);
	   }
	   
}
