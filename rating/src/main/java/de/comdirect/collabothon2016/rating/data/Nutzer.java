package de.comdirect.collabothon2016.rating.data;

import java.util.Map;


public class Nutzer {
	private long nutzerId;
	private String name;
	private long globalScore;
	
	public Nutzer(long nutzerId, long globalScore, String name){
		this.nutzerId=nutzerId;
		this.globalScore=globalScore;
		this.name=name;
	}
	
	public Nutzer(long nutzerId, long globalScore){
		this.nutzerId=nutzerId;
		this.globalScore=globalScore;
	}
	

	public long getNutzerId() {
		return nutzerId;
	}

	public void setNutzerId(long nutzerId) {
		this.nutzerId = nutzerId;
	}

	public long getGlobalScores() {
		return globalScore;
	}

	public void setGlobalScores(long globalScore) {
		this.globalScore = globalScore;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (nutzerId ^ (nutzerId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nutzer other = (Nutzer) obj;
		if (nutzerId != other.nutzerId)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return String.valueOf(nutzerId);
	}
}
