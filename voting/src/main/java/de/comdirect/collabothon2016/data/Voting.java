package de.comdirect.collabothon2016.data;

import java.util.ArrayList;
import java.util.List;

public class Voting {

	private List<InvestmentSuggestion> investmentSuggestions = new ArrayList<>();
	
	private String groupId;
	
	private boolean active;

	public List<InvestmentSuggestion> getInvestmentSuggestions() {
		return investmentSuggestions;
	}

	public void setInvestmentSuggestions(List<InvestmentSuggestion> investmentSuggestions) {
		this.investmentSuggestions = investmentSuggestions;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	
}
