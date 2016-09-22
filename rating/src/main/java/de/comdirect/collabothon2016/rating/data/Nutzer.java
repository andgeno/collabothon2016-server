package de.comdirect.collabothon2016.rating.data;

import java.util.Map;


public class Nutzer {
	private long id;
	private Map<Group, Score> scores;
	
	public Nutzer(long id, Map<Group, Score> scores){
		this.id=id;
		this.scores=scores;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Map<Group, Score> getScores() {
		return scores;
	}

	public void setScores(Map<Group, Score> scores) {
		this.scores = scores;
	}
}
