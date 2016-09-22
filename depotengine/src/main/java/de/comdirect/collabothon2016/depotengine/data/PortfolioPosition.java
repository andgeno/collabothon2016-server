package de.comdirect.collabothon2016.depotengine.data;

public class PortfolioPosition{

	private String wkn;
	private String wertpapiername;
	private long amount;
	private double kursWert;
	private String kursWaehrung;
	private double gewinnBetrag;
	private double gewinnProzent;
	private double stueckzins;
	private double anteilAmAUM;
	
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
	public double getKursWert() {
		return kursWert;
	}
	public void setKursWert(double kursWert) {
		this.kursWert = kursWert;
	}
	public double getGewinnBetrag() {
		return gewinnBetrag;
	}
	public void setGewinnBetrag(double gewinnBetrag) {
		this.gewinnBetrag = gewinnBetrag;
	}
	public double getGewinnProzent() {
		return gewinnProzent;
	}
	public void setGewinnProzent(double gewinnProzent) {
		this.gewinnProzent = gewinnProzent;
	}
	public double getStueckzins() {
		return stueckzins;
	}
	public void setStueckzins(double stueckzins) {
		this.stueckzins = stueckzins;
	}
	public double getAnteilAmAUM() {
		return anteilAmAUM;
	}
	public void setAnteilAmAUM(double anteilAmAUM) {
		this.anteilAmAUM = anteilAmAUM;
	}
	public String getWertpapiername() {
		return wertpapiername;
	}
	public void setWertpapiername(String wertpapiername) {
		this.wertpapiername = wertpapiername;
	}
	public String getKursWaehrung() {
		return kursWaehrung;
	}
	public void setKursWaehrung(String kursWaehrung) {
		this.kursWaehrung = kursWaehrung;
	}
	
	
}
