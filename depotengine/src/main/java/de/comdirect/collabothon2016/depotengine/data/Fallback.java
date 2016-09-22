package de.comdirect.collabothon2016.depotengine.data;


public class Fallback {

	public static Portfolio getFallback()
	{
		Portfolio portfolio = new Portfolio();
		
		portfolio.setCapitalAccountNumber("1182000001");
		portfolio.setPortfolioNumber("118200000100");
		portfolio.setCustomerNumber("118200000140");
		
		portfolio.add(createPostion(100, "710000", "Daimler AG", 0, 6.2, 4.0, 20, 63.420, "EUR"));
		portfolio.add(createPostion(100, "BAY001", "Bayer AG", 0, 1.2, 1.0, 30, 92.220, "EUR"));
		portfolio.add(createPostion(100, "113504", "Deutschland, Bundesrepublik Anleihe: 6,500% bis 04.07.2027", 0, 5.2, 4.2, 30, 171.75, "%" ));
		portfolio.add(createPostion(100, "542800", "comdirect bank AG", 1.44, 12.4, 1.4, 20, 92.220, "EUR"));
		
		return portfolio;
	}

	private static PortfolioPosition createPostion( long amount, String wkn, String wertpapiername, double stueckzins, double gewinnBetrag, double gewinnProzent, double anteilAmAUM, double kursWert, String waehrung) {
		PortfolioPosition portfolioPosition = new PortfolioPosition();
		portfolioPosition.setAmount(amount);
		portfolioPosition.setWkn(wkn);
		portfolioPosition.setWertpapiername(wertpapiername);
		portfolioPosition.setKursWert(kursWert);
		portfolioPosition.setKursWaehrung(waehrung);
		portfolioPosition.setStueckzins(stueckzins);
		portfolioPosition.setGewinnBetrag(gewinnBetrag);
		portfolioPosition.setGewinnProzent(gewinnProzent);
		portfolioPosition.setAnteilAmAUM(anteilAmAUM);
		return portfolioPosition;
	}
	
}
