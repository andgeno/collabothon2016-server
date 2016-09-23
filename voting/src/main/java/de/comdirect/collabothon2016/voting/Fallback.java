package de.comdirect.collabothon2016.voting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.comdirect.collabothon2016.data.InvestmentSuggestion;
import de.comdirect.collabothon2016.data.Voting;

public class Fallback {

	public static HashMap<Long,List<InvestmentSuggestion>> getInvestmentSuggestion()
	{
		InvestmentSuggestion suggestion = new InvestmentSuggestion();
		suggestion.setTitle("In Edelholz investieren");
		suggestion.setComment("Für eine langfristige und sachwertorientierte Edelholzgeldanlage. Das erklärte Ziel ist es, neben überdurchschnittlichen Erträgen ein Maximum an Umweltschutz, Ökologie und Klimaschutz zu berücksichtigen, um einen Mehrwert für Sie und unsere Erde zu schaffen");
		suggestion.setUserId(1);
		suggestion.setVotes(3);
		
		List<InvestmentSuggestion> investmentSuggestions = new ArrayList<>();
		HashMap<Long,List<InvestmentSuggestion>> s = new HashMap<Long,List<InvestmentSuggestion>>();
		s.put(1000L, investmentSuggestions);
		investmentSuggestions.add(suggestion);
		return s;
	}
	
	public static Map<Long, Voting> getVoting(HashMap<Long, List<InvestmentSuggestion>> suggestions){
		Map<Long, Voting> votings = new HashMap<>();
		for (Long groupId : suggestions.keySet()){
			Voting voting = new Voting();
			voting.setGroupId("" + groupId);
			voting.setActive(true);
			voting.setInvestmentSuggestions(suggestions.get(groupId));
			votings.put(groupId, voting);
		}
		
		return votings;
		
	}
	
}
