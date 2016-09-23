package de.comdirect.collabothon2016.data;

public class InvestmentSuggestion {
	
	private long userId;
	
	private long indexInVote;
	
	private String title;
	
	private String comment;
	
	private long votes;
	
	private String wertpapier;
	
	
	public InvestmentSuggestion(){
		votes = 0;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public long getVotes() {
		return votes;
	}

	public void setVotes(long votes) {
		this.votes = votes;
	}

	public void addVote(){
		this.votes++;
	}

	public long getIndexInVote() {
		return indexInVote;
	}

	public void setIndexInVote(long indexInVote) {
		this.indexInVote = indexInVote;
	}

	public String getWertpapier() {
		return wertpapier;
	}

	public void setWertpapier(String wertpapier) {
		this.wertpapier = wertpapier;
	}
}
