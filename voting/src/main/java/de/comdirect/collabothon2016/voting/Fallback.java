package de.comdirect.collabothon2016.voting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.comdirect.collabothon2016.data.InvestmentSuggestion;
import de.comdirect.collabothon2016.data.Voting;
import de.comdirect.collabothon2016.data.LeaderBoardEntry;

public class Fallback {

	public static HashMap<Long,List<InvestmentSuggestion>> getInvestmentSuggestion()
	{
		List<InvestmentSuggestion> investmentSuggestions = new ArrayList<>();

		InvestmentSuggestion suggestion = new InvestmentSuggestion();
		suggestion.setTitle("Facebook Inc.");
		suggestion.setWertpapier("US30303M1027");
		suggestion.setComment("Analysts: 28/30 in favor");
		suggestion.setUserId(1);
		suggestion.setVotes(2);
		investmentSuggestions.add(suggestion);

		InvestmentSuggestion suggestion1 = new InvestmentSuggestion();
		suggestion1.setTitle("Netflix Inc.");
		suggestion1.setWertpapier("US64110L1061");
		suggestion1.setComment("CNBC: Stock doubling in 3 years?");
		suggestion1.setUserId(3);
		suggestion1.setVotes(1);
		investmentSuggestions.add(suggestion1);
	
		InvestmentSuggestion suggestion2 = new InvestmentSuggestion();
		suggestion2.setTitle("Tesla");
		suggestion2.setWertpapier("US88160R1014");
		suggestion2.setComment("Solar roof brings new potential!");
		suggestion2.setUserId(1);
		suggestion2.setVotes(1);
		investmentSuggestions.add(suggestion2);
		
		InvestmentSuggestion suggestion3 = new InvestmentSuggestion();
		suggestion3.setTitle("GoPro");
		suggestion3.setWertpapier("US38268T1034");
		suggestion3.setComment("Technical long momentum impulse");
		suggestion3.setUserId(2);
		suggestion3.setVotes(1);
		investmentSuggestions.add(suggestion3);
		
		InvestmentSuggestion suggestion4 = new InvestmentSuggestion();
		suggestion4.setTitle("Alphabet Inc. (A)");
		suggestion4.setWertpapier("US02079K3059");
		suggestion4.setComment("Portfolio improvement through AirBNB investment");
		suggestion4.setUserId(3);
		suggestion4.setVotes(1);
		investmentSuggestions.add(suggestion4);
		
		InvestmentSuggestion suggestion5 = new InvestmentSuggestion();
		suggestion5.setTitle("Apple Inc. (A)");
		suggestion5.setWertpapier("US0378331005");
		suggestion5.setComment("Always good");
		suggestion5.setUserId(3);
		suggestion5.setVotes(1);
		investmentSuggestions.add(suggestion5);
		
		
		HashMap<Long,List<InvestmentSuggestion>> s = new HashMap<Long,List<InvestmentSuggestion>>();
		investmentSuggestions.add(suggestion);
		s.put(1L, investmentSuggestions);
		
		List<InvestmentSuggestion> investmentSuggestions2 = new ArrayList<>();

		InvestmentSuggestion suggestion6 = new InvestmentSuggestion();
		suggestion6.setTitle("LVMH");
		suggestion6.setWertpapier("FR0000121014");
		suggestion6.setComment("I see high potential for LVMH");
		suggestion6.setUserId(2);
		suggestion6.setVotes(2);
		investmentSuggestions2.add(suggestion);
		
		s.put(3L, investmentSuggestions);
		
		return s;
	}

	public static HashMap<Long, List<LeaderBoardEntry>> getLeaderBoard() {
		List<LeaderBoardEntry> leaderBoard = new ArrayList<>();

		LeaderBoardEntry entry = new LeaderBoardEntry();
		entry.setNutzerId(1);
		entry.setPerformance(12.21);
		entry.setPosition(1);
		entry.setName("Walter");
		leaderBoard.add(entry);

		entry = new LeaderBoardEntry();
		entry.setNutzerId(2);
		entry.setPerformance(9.7);
		entry.setPosition(2);
		entry.setName("Wilhelm");
		leaderBoard.add(entry);

		entry = new LeaderBoardEntry();
		entry.setNutzerId(3);
		entry.setPerformance(-2.3);
		entry.setPosition(3);
		entry.setName("Gabi");
		leaderBoard.add(entry);
		
		entry = new LeaderBoardEntry();
		entry.setNutzerId(4);
		entry.setPerformance(-2.9);
		entry.setPosition(4);
		entry.setName("Katja");
		leaderBoard.add(entry);
		
		entry = new LeaderBoardEntry();
		entry.setNutzerId(5);
		entry.setPerformance(-3.3);
		entry.setPosition(5);
		entry.setName("Richard");
		leaderBoard.add(entry);
		
		HashMap<Long,List<LeaderBoardEntry>> allBoards = new HashMap<Long,List<LeaderBoardEntry>>();
		
		allBoards.put(0L, leaderBoard);
		
		
		
		return allBoards;
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
