package de.comdirect.collabothon2016.depotengine;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import de.comdirect.collabothon2016.depotengine.controller.PortfolioController;
import de.comdirect.collabothon2016.depotengine.data.DepotuserCredentials;
import de.comdirect.collabothon2016.depotengine.data.Portfolio;

@RunWith(SpringRunner.class)
@SpringBootTest//(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DepotengineTest {

	@Autowired
	public PortfolioController portfolioController;
	
	@Test
	public void smokeTest(){
		
	}
	
//	@Test
	public void usecaseTest(){
		DepotuserCredentials credentials = new DepotuserCredentials();
		credentials.setPin("1234");
		credentials.setZugangsnummer("007");
		portfolioController.registerVotingGroup(1, "1234567", credentials);
		
		ResponseEntity<Portfolio> portfolio = portfolioController.getPortfolio(1);
		System.out.println("" + portfolio.getBody().getPortfolioNumber());
		System.out.println("" + portfolio.getBody().getPortfolioPositions().size());
	}
}
