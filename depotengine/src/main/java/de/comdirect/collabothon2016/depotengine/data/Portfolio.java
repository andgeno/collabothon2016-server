package de.comdirect.collabothon2016.depotengine.data;

import java.util.ArrayList;
import java.util.List;

public class Portfolio{

	private String portfolioNumber;
	private String customerNumber;
	private String capitalAccountNumber;
	private double portfolioValue;
	private List<PortfolioPosition> portfolioPositions = new ArrayList<>();
	
	public String getPortfolioNumber() {
		return portfolioNumber;
	}
	public void add(PortfolioPosition position){
		portfolioPositions.add(position);
	}
	public void setPortfolioNumber(String portfolioNumber) {
		this.portfolioNumber = portfolioNumber;
	}
	public String getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}
	public String getCapitalAccountNumber() {
		return capitalAccountNumber;
	}
	public void setCapitalAccountNumber(String capitalAccountNumber) {
		this.capitalAccountNumber = capitalAccountNumber;
	}
	public List<PortfolioPosition> getPortfolioPositions() {
		return portfolioPositions;
	}
	public void setPortfolioPositions(List<PortfolioPosition> portfolioPositions) {
		this.portfolioPositions = portfolioPositions;
	}
	public double getPortfolioValue() {
		return portfolioValue;
	}
	public void setPortfolioValue(double portfolioValue) {
		this.portfolioValue = portfolioValue;
	}
	
	
	
}
