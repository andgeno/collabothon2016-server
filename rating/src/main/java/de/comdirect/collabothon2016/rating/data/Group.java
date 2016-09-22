package de.comdirect.collabothon2016.rating.data;

import java.util.Map;

public class Group {
	private long id;
	private String groupname;
	
	public String getGroupName() {
		return groupname;
	}


	public void setGroupName(String name) {
		this.groupname = name;
	}

	private Map<Nutzer,GroupScore> usersScores;
	private String interval;
	private int amount;
	private String nextPeriod;
	private String investingSince;
	private long amount_overall;
	
	
	public Group(long id,String groupname, Map<Nutzer,GroupScore> usersScores, String interval, int amount, String nextPeriod, String investingSince, long amount_overall){
		this.id = id;
		this.groupname=groupname;
		this.usersScores = usersScores;
		this.interval=interval;
		this.amount=amount;
		this.nextPeriod = nextPeriod;
		this.investingSince=investingSince;
		this.amount_overall = amount_overall;
	}

	
	public Group(long id, Map<Nutzer,GroupScore> usersScores){
		this.id = id;
		this.usersScores = usersScores;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Map<Nutzer,GroupScore> getUsers() {
		return usersScores;
	}

	public void setUsersScores(Map<Nutzer,GroupScore> usersScores) {
		this.usersScores = usersScores;
	}

	public String getInterval() {
		return interval;
	}

	public void setInterval(String interval) {
		this.interval = interval;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getNextPeriod() {
		return nextPeriod;
	}

	public void setNextPeriod(String nextPeriod) {
		this.nextPeriod = nextPeriod;
	}

	public long getAmountOverall() {
		return amount_overall;
	}

	public void setAmountOverall(long amount_overall) {
		this.amount_overall = amount_overall;
	}

	public Map<Nutzer, GroupScore> getUsersScores() {
		return usersScores;
	}

	public String getInvestingSince() {
		return investingSince;
	}


	public void setInvestingSince(String investingSince) {
		this.investingSince = investingSince;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Group other = (Group) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
