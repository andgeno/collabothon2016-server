package de.comdirect.collabothon2016.depotengine.data;

public class NutzerFromServerTO {

	private long nutzerId;
	private String name;
	private long globalScore;
	
	public NutzerFromServerTO(long nutzerId, long globalScore, String name){
		this.nutzerId=nutzerId;
		this.globalScore=globalScore;
		this.name=name;
	}
	
	public NutzerFromServerTO(long nutzerId, long globalScore){
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
}
