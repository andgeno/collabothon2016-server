package de.comdirect.collabothon2016.depotenegine.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.comdirect.collabothon2016.depotenegine.data.Portfolio;

@RestController
public class PortfolioController {

	private Map<String, String> groupToPortfolionumber = new HashMap<>();
	
//	@RequestMapping(method=RequestMethod.GET, path="/portfolio/{groupid}")
//	public ResponseEntity<Portfolio> getPortfolio(@PathVariable(value="groupid")String groupnumber){
//		Portfolio portfolio = new Portfolio();
//		portfolio.setPortfolioNumber("123456");
//		portfolio.setCustomerNumber("1234");
//		portfolio.setCapitalAccountNumber("12345600");
//		return new ResponseEntity<>(portfolio, HttpStatus.OK);
//	}
	
	@RequestMapping(method=RequestMethod.GET, path="/portfolio/number/{groupid}")
	public ResponseEntity<Long> getPortfolioNumber(@PathVariable(value="groupid") long groupid){
		System.out.println("portfolio for number " + groupid);
		return new ResponseEntity<Long>(groupid, HttpStatus.OK);
	}
}

