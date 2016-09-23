package de.comdirect.collabothon2016.depotengine.data;

/**
 * {
   "sessionId": "4c9dd5a4-f688-447b-8405-c134a36101a9",
   "kdnr": "1234567890",
   "personId": "3"
}
 * @author A4595419
 *
 */
public class SecurityLoginInformationTO {

	private String sessionId;
	private String kdnr;
	private String personId;
	
	
	
	
	public SecurityLoginInformationTO() {
		super();
	}
	public SecurityLoginInformationTO(String sessionId, String kdnr, String personId) {
		super();
		this.sessionId = sessionId;
		this.kdnr = kdnr;
		this.personId = personId;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getKdnr() {
		return kdnr;
	}
	public void setKdnr(String kdnr) {
		this.kdnr = kdnr;
	}
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	@Override
	public String toString() {
		return "SecurityLoginInformationTO [sessionId=" + sessionId + ", kdnr=" + kdnr + ", personId=" + personId + "]";
	}
	
	
}
