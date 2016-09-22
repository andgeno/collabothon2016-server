package de.comdirect.collabothon2016.voting;

import java.util.ArrayList;
import java.util.List;

import de.comdirect.collabothon2016.data.InvestmentSuggestion;

public class Fallback {

	public static List<InvestmentSuggestion> getInvestmentSuggestion()
	{
		InvestmentSuggestion suggestion = new InvestmentSuggestion();
		suggestion.setTitle("In Edelholz investieren");
		suggestion.setComment("Für eine langfristige und sachwertorientierte Edelholzgeldanlage. Das erklärte Ziel ist es, neben überdurchschnittlichen Erträgen ein Maximum an Umweltschutz, Ökologie und Klimaschutz zu berücksichtigen, um einen Mehrwert für Sie und unsere Erde zu schaffen");
		suggestion.setUserId(1);
		
		List<InvestmentSuggestion> investmentSuggestions = new ArrayList<>();
		investmentSuggestions.add(suggestion);
		
		return investmentSuggestions;
	}
	
}
