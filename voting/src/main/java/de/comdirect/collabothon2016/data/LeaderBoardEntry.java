package de.comdirect.collabothon2016.data;

public class LeaderBoardEntry {

	public long position;
	public long nutzerId;
	public double performance;
	private String name;
	
	public long getPosition() {
		return position;
	}
	public void setPosition(long position) {
		this.position = position;
	}
	public long getNutzerId() {
		return nutzerId;
	}
	public void setNutzerId(long nutzerId) {
		this.nutzerId = nutzerId;
	}
	public double getPerformance() {
		return performance;
	}
	public void setPerformance(double performance) {
		this.performance = performance;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
