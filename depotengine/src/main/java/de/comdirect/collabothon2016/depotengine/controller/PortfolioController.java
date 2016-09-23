package de.comdirect.collabothon2016.depotengine.controller;

import java.io.File;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import de.comdirect.collabothon2016.depotengine.DepotengineRestConnections;
import de.comdirect.collabothon2016.depotengine.data.DepotuserCredentials;
import de.comdirect.collabothon2016.depotengine.data.Fallback;
import de.comdirect.collabothon2016.depotengine.data.Portfolio;
import de.comdirect.collabothon2016.depotengine.data.PortfolioInformationFromServerTO;
import de.comdirect.collabothon2016.depotengine.data.PortfolioPosition;
import de.comdirect.collabothon2016.depotengine.data.SecurityLoginInformation;
import de.comdirect.collabothon2016.depotengine.data.SecurityLoginInformationTO;

/**
 * 
 * @author A4595419
 *
 */
@RestController
public class PortfolioController {
	
	@Autowired
	RestOperations restOperations;

	// the database ... :)
	private Map<String, String> groupToPortfolionumber = new HashMap<>();
	private Map<String, DepotuserCredentials> portfolionumberToCredentials = new HashMap<>();
	private Map<String, String> groupToOpenVotings = new HashMap<>();
	private long votingCounter = 1;
	
	
	/**
	 * Register a new Group for voting system or tells the portfolio manager a new voting group 
	 * @param groupid the id
	 * @param portfolioId the portfolionumber
	 * @param depotuserCredentials credentials for managing the depot
	 * @return the group id
	 */
	@RequestMapping(method=RequestMethod.POST, path="/portfolio/group/{groupid}/portfolio/{portfolioid}")
	public ResponseEntity<Long> registerVotingGroup(@PathVariable(value="groupid") long groupid, @PathVariable(value="portfolioid")  String portfolioId, @RequestBody DepotuserCredentials depotuserCredentials){
		if (groupToPortfolionumber.containsKey("" + groupid) || groupToPortfolionumber.containsValue(portfolioId)){
			System.out.println("double groupId and portfolioid");
			return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
		}else{
			if (!checkContractForPortfolioProvisioning("" + groupid, portfolioId)){
				return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
			}
			System.out.println("Now, portfolio is blocked for user transactions");
			groupToPortfolionumber.put("" + groupid, portfolioId);
			portfolionumberToCredentials.put(portfolioId, depotuserCredentials);
			System.out.println("Credentials for portfolio " + portfolioId + " are saved with zugriffnummer='" + depotuserCredentials.getZugangsnummer() + "', pin='" + depotuserCredentials.getPin() + "'");
			return new ResponseEntity<Long>(groupid, HttpStatus.CREATED);
		}
	}
	
	@RequestMapping(method=RequestMethod.POST, path="/portfolio/{groupid}/payment")
	public ResponseEntity<Void> makePayment(@PathVariable(value="groupid") long groupId){
		RestClient.makePayment(groupId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/**
	 * The voting system may send a signal, so that the portfolio manager will gather the voting and
	 * make an order.
	 * 
	 * @param groupId group-id
	 * @return nothing to say
	 */
	@RequestMapping(method=RequestMethod.POST, path="/portfolio/group/{groupid}/voting/{votingid}/order")
	public ResponseEntity<Void> signalVotingResult(@PathVariable(value="groupid") long groupId,@PathVariable(value="votingid") long votingId){
		// 1 : fetch the voting results
//		restOperations.getForEntity(DepotengineRestConnections.URL_VOTING + DepotengineRestConnections.PATH_GET_VOTINGWINNER + groupId; 
		
		// 2 : check the contract for group-provisioning
		// 3 : check the contract for paying
		
		boolean paymentDone = RestClient.checkPayment(groupId);
		RestClient.makePayment(groupId);
		if (!paymentDone){
			System.out.println("Payment isnt done yet");
			return new ResponseEntity<>(HttpStatus.DESTINATION_LOCKED);
		}
		// 4 : check the block-chain-payment
		
		// build orders
		String portfolioNumber = groupToPortfolionumber.get("" + groupId);
//		Optional<SecurityLoginInformationTO> sessionSecurityInformation = startNewSession(portfolioNumber);
		
		
		// build an order
//		HttpHeaders headers = new HttpHeaders();
//		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
//		headers.add("Authorization", sessionSecurityInformation.get().getSessionId());
//		
//		System.out.println("URL=" + DepotengineRestConnections.URL + DepotengineRestConnections.PATH_NEW_ORDER);
//		System.out.println("Authorization=" + sessionSecurityInformation.get().getSessionId());
//		
//		ResponseEntity<PortfolioInformationFromServerTO> portfolioInformationFromServerTo = restOperations.exchange(DepotengineRestConnections.URL + DepotengineRestConnections.PATH_NEW_ORDER , HttpMethod.POST, entity, PortfolioInformationFromServerTO.class);
//		System.out.println("" + portfolioInformationFromServerTo.getBody().getDepotnr());
//		System.out.println("" + portfolioInformationFromServerTo.getBody().getKdnr());
//		
//		endSession(sessionSecurityInformation);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, path="/portfolio/group/{groupid}/voting")
	public ResponseEntity<Long> startVoting(@PathVariable(value="groupid")long groupId){
		groupToOpenVotings.put("" + groupId, "" + votingCounter);
		votingCounter++;
		
		return new ResponseEntity<Long>(1L, HttpStatus.OK);
	}
	
	/**
	 * Gathers informations for the group portfolio, portfolio informations and portfolio positions.
	 * 
	 * @param groupid the group-ID of the group
	 * @return the full portfolio information
	 */
	@RequestMapping(method=RequestMethod.GET, path="/portfolio/{groupid}")
	public ResponseEntity<Portfolio> getPortfolio(@PathVariable(value="groupid") long groupid){
		
		String portfolionumber = null;
		
		portfolionumber = groupToPortfolionumber.get("" + groupid);
		
		if (portfolionumber == null){
			System.out.println("group " + groupid+ " is not provisioned");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		Portfolio portfolio = readPortfolio(portfolionumber);
		return new ResponseEntity<Portfolio>(portfolio, HttpStatus.OK);
	}
	

	private Portfolio readPortfolio(String depotnumber){
		Portfolio portfolio = null;
		Optional<SecurityLoginInformationTO> securitySessionInformation = startNewSession(depotnumber);
		if (securitySessionInformation.isPresent()){
			try{
			System.out.println("Login done: " + securitySessionInformation.get().toString());
			
			Map<String, String> arguments = new HashMap<>();
			arguments.put("Authorization", securitySessionInformation.get().getSessionId());
			
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			HttpEntity<String> entity = new HttpEntity<String>("", headers);
			headers.add("Authorization", securitySessionInformation.get().getSessionId());
			
			System.out.println("URL=" + DepotengineRestConnections.URL + DepotengineRestConnections.PATH_PORTFOLIO + depotnumber);
			System.out.println("Authorization=" + securitySessionInformation.get().getSessionId());
			
			ResponseEntity<PortfolioInformationFromServerTO> portfolioInformationFromServerTo = restOperations.exchange(DepotengineRestConnections.URL + DepotengineRestConnections.PATH_PORTFOLIO + depotnumber, HttpMethod.GET, entity, PortfolioInformationFromServerTO.class);
			System.out.println("" + portfolioInformationFromServerTo.getBody().getDepotnr());
			System.out.println("" + portfolioInformationFromServerTo.getBody().getKdnr());
			
			endSession(securitySessionInformation);
			}catch(Exception e){
				System.out.println("Exception:" + e.getMessage());
			}
		}else{
			
		}
		
		return portfolio==null ? Fallback.getFallback() : portfolio;
	}
	
	private List<PortfolioPosition> getPortfolioPositions(String depotnumber, DepotuserCredentials depotuserCredentials){
		return Collections.EMPTY_LIST;
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
	
	/**
	 * Gets the portfolionumber for the group.
	 * @param groupid the group-id
	 * @return the portfolio number
	 */
	@RequestMapping(method=RequestMethod.GET, path="/portfolio/number/{groupid}")
	public ResponseEntity<Long> getPortfolioNumber(@PathVariable(value="groupid") long groupid){
		System.out.println("portfolio for number " + groupid);
		return new ResponseEntity<Long>(groupid, HttpStatus.OK);
	}
	
	private Optional<SecurityLoginInformationTO> startNewSession(String portfolionumber){
		DepotuserCredentials depotuserCredentials = portfolionumberToCredentials.get(portfolionumber);
		SecurityLoginInformation securityLoginInformation = new SecurityLoginInformation(depotuserCredentials);
		
		try{
		SecurityLoginInformationTO securityLoginInformationTO = restOperations.postForObject(DepotengineRestConnections.URL + DepotengineRestConnections.PATH_LOGIN, securityLoginInformation, SecurityLoginInformationTO.class);
		if (securityLoginInformationTO!=null){
			return Optional.of(securityLoginInformationTO);
		}
		}catch(Exception e){
			
		}
		return Optional.empty();
		
	}
	
	private void endSession(Optional<SecurityLoginInformationTO> securityLoginInformationTo){
		securityLoginInformationTo.ifPresent((s) -> restOperations.delete(DepotengineRestConnections.URL + "/api/v1/sicherheit/sessions/" + s.getSessionId()));
	}
}

