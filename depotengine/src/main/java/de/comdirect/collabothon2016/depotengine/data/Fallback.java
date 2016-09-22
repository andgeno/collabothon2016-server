package de.comdirect.collabothon2016.depotengine.data;


public class Fallback {

	public static Portfolio getFallback()
	{
		Portfolio portfolio = new Portfolio();
		
		portfolio.setCapitalAccountNumber("1182000001");
		portfolio.setPortfolioNumber("118200000100");
		portfolio.setCustomerNumber("118200000140");
		
		portfolio.add(createPostion(100, "710000"));
		
		return portfolio;
	}

	private static PortfolioPosition createPostion( long amount, String wkn) {
		PortfolioPosition portfolioPosition = new PortfolioPosition();
		portfolioPosition.setAmount(amount);
		portfolioPosition.setWkn(wkn);
		return portfolioPosition;
	}
	
}
