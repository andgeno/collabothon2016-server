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

import de.comdirect.collabothon2016.depotengine.data.Fallback;
import de.comdirect.collabothon2016.depotengine.data.Portfolio;
import de.comdirect.collabothon2016.depotengine.data.PortfolioPosition;

@RestController
public class PortfolioController {

	private Map<String, String> groupToPortfolionumber = new HashMap<>();
	
	@RequestMapping(method=RequestMethod.POST, path="/portfolio/group/{groupid}/portfolio/{portfolioid}")
	public ResponseEntity<Long> registerVotingGroup(@PathVariable(value="groupid") long groupid, @PathVariable(value="portfolioid")  String portfolioId){
		if (groupToPortfolionumber.containsKey("" + groupid) || groupToPortfolionumber.containsValue(portfolioId)){
			System.out.println("double groupId and portfolioid");
			return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
		}else{
			if (!checkContractForPortfolioProvisioning("" + groupid, portfolioId)){
				return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
			}
			System.out.println("Now, portfolio is blocked for user transactions");
			groupToPortfolionumber.put("" + groupid, portfolioId);
			return new ResponseEntity<Long>(groupid, HttpStatus.CREATED);
		}
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/portfolio/{groupid}")
	public ResponseEntity<Portfolio> getPortfolio(@PathVariable(value="groupid") long groupid){
		
		String depotnumber = null;
		
		depotnumber = groupToPortfolionumber.get("" + groupid);
		
		
//		if (depotnumber == null){
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
		
		
		
		Portfolio portfolio = readPortfolio(depotnumber);
		
		
		
		return new ResponseEntity<Portfolio>(portfolio, HttpStatus.OK);
	}

	private Portfolio readPortfolio(String depotnumber){
//		RestTemplate restTemplate = new RestTemplate();
//		restTemplate.getForObject("https://cdavmd01.northeurope.cloudapp.azure.com/api/v1/sicherheit/sessions", Long.class);
		
		
		
		return Fallback.getFallback();
	}
	
	private boolean checkContractForPortfolioProvisioning(String groupid, String portfolioid){
		System.out.println("Checking smart contract for provision portfolio for group");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("OK, all attendies confirmed contract");
		return true;
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/portfolio/number/{groupid}")
	public ResponseEntity<Long> getPortfolioNumber(@PathVariable(value="groupid") long groupid){
		System.out.println("portfolio for number " + groupid);
		return new ResponseEntity<Long>(groupid, HttpStatus.OK);
	}
}

