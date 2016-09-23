package de.comdirect.collabothon2016.voting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import de.comdirect.collabothon2016.data.InvestmentSuggestion;
import de.comdirect.collabothon2016.data.LeaderBoardEntry;

public class Fallback {

	public static HashMap<Long,List<InvestmentSuggestion>> getInvestmentSuggestion()
	{
		InvestmentSuggestion suggestion = new InvestmentSuggestion();
		List<InvestmentSuggestion> investmentSuggestions = new ArrayList<>();

		suggestion.setTitle("Facebook Inc.");
		suggestion.setWertpapier("US30303M1027");
		suggestion.setComment("Analysts: 28/30 in favor");
		suggestion.setUserId(1);
		suggestion.setVotes(2);
		investmentSuggestions.add(suggestion);

		suggestion.setTitle("Netflix Inc.");
		suggestion.setWertpapier("US64110L1061");
		suggestion.setComment("CNBC: Stock doubling in 3 years?");
		suggestion.setUserId(3);
		suggestion.setVotes(1);
		investmentSuggestions.add(suggestion);
	
		suggestion.setTitle("Tesla");
		suggestion.setWertpapier("US88160R1014");
		suggestion.setComment("Solar roof brings new potential!");
		suggestion.setUserId(1);
		suggestion.setVotes(1);
		investmentSuggestions.add(suggestion);
		
		suggestion.setTitle("GoPro");
		suggestion.setWertpapier("US88160R1014");
		suggestion.setComment("Technical long momentum impulse");
		suggestion.setUserId(2);
		suggestion.setVotes(1);
		investmentSuggestions.add(suggestion);
		
		suggestion.setTitle("Alphabet Inc. (A)");
		suggestion.setWertpapier("US02079K3059");
		suggestion.setComment("Portfolio improvement through AirBNB investment");
		suggestion.setUserId(3);
		suggestion.setVotes(1);
		investmentSuggestions.add(suggestion);
		
		suggestion.setTitle("Apple Inc. (A)");
		suggestion.setWertpapier("US0378331005");
		suggestion.setComment("Always good");
		suggestion.setUserId(3);
		suggestion.setVotes(1);
		investmentSuggestions.add(suggestion);
		
		HashMap<Long,List<InvestmentSuggestion>> s = new HashMap<Long,List<InvestmentSuggestion>>();
		
		s.put(1L, investmentSuggestions);
		return s;
	}

	public static HashMap<Long, List<LeaderBoardEntry>> getLeaderBoard() {
		LeaderBoardEntry entry = new LeaderBoardEntry();
		List<LeaderBoardEntry> leaderBoard = new ArrayList<>();

		entry.setNutzerId(1);
		entry.setPerformance(12.21);
		entry.setPosition(0);
		leaderBoard.add(entry);

		entry.setNutzerId(2);
		entry.setPerformance(9.7);
		entry.setPosition(1);
		leaderBoard.add(entry);

		entry.setNutzerId(3);
		entry.setPerformance(-2.3);
		entry.setPosition(3);
		leaderBoard.add(entry);
		
		HashMap<Long,List<LeaderBoardEntry>> allBoards = new HashMap<Long,List<LeaderBoardEntry>>();
		
		allBoards.put(0L, leaderBoard);
		
		
		
		return null;
	}
	
}
