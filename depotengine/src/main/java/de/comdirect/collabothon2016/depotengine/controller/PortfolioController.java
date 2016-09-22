package de.comdirect.collabothon2016.depotengine.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import de.comdirect.collabothon2016.depotengine.data.Portfolio;
import de.comdirect.collabothon2016.depotengine.data.PortfolioPosition;

@RestController
public class PortfolioController {

	private Map<String, String> groupToPortfolionumber = new HashMap<>();
	
	@RequestMapping(method=RequestMethod.GET, path="/portfolio/{groupid}")
	public ResponseEntity<Portfolio> getPortfolio(@PathVariable(value="groupid") long groupid){
		
		String depotnumber = null;
		
		depotnumber = groupToPortfolionumber.get("" + groupid);
		
		
		if (depotnumber == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
		
		Portfolio portfolio = new Portfolio();
		portfolio.setPortfolioNumber("1234");
		portfolio.setCapitalAccountNumber("134500");
		portfolio.setCustomerNumber("1234");
		
		PortfolioPosition position = new PortfolioPosition();
		position.setAmount(1);
		position.setWkn("111111");
		portfolio.add(position);
		
		position = new PortfolioPosition();
		position.setAmount(2);
		position.setWkn("222222");
		portfolio.add(position);
		
		
		
		return new ResponseEntity<Portfolio>(portfolio, HttpStatus.OK);
	}

	private void foo(String depotnumber){
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getForObject("https://cdavmd01.northeurope.cloudapp.azure.com/api/v1/sicherheit/sessions", Long.class);
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/portfolio/number/{groupid}")
	public ResponseEntity<Long> getPortfolioNumber(@PathVariable(value="groupid") long groupid){
		System.out.println("portfolio for number " + groupid);
		return new ResponseEntity<Long>(groupid, HttpStatus.OK);
	}
}

