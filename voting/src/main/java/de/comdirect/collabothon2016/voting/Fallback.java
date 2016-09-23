package de.comdirect.collabothon2016.voting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import de.comdirect.collabothon2016.data.InvestmentSuggestion;
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
		suggestion3.setWertpapier("US88160R1014");
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
