package de.comdirect.collabothon2016.depotengine.data;

import java.io.Serializable;
import java.util.List;

public class PortfolioPosition{

	private String wkn;
	private long amount;
	public String getWkn() {
		return wkn;
	}
	public void setWkn(String wkn) {
		this.wkn = wkn;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	
	
}
