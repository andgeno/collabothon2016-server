package de.comdirect.collabothon2016.depotengine.data;

/**
 * {
        "apiKey":  "c2f6a3ce-7f5b-4a19-ac64-2931ac0268b1",
        "zugangsnummer": "007",
        "pin": "1234"
}
 * @author A4595419
 *
 */
public class SecurityLoginInformation {

	private static final String API_KEY = "c2f6a3ce-7f5b-4a19-ac64-2931ac0268b1";
	private String apiKey;
	private String zugangsnummer;
	private String pin;
	
	public SecurityLoginInformation(DepotuserCredentials depotuserCredentials){
		this(API_KEY, depotuserCredentials.getZugangsnummer(), depotuserCredentials.getPin());
	}
	public SecurityLoginInformation(){
		this(API_KEY, "007", "1234");
	}
	public SecurityLoginInformation(String apiKey, String zugangsnummer, String pin) {
		super();
		this.apiKey = apiKey;
		this.zugangsnummer = zugangsnummer;
		this.pin = pin;
	}
	public String getApiKey() {
		return apiKey;
	}
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	public String getZugangsnummer() {
		return zugangsnummer;
	}
	public void setZugangsnummer(String zugangsnummer) {
		this.zugangsnummer = zugangsnummer;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	
	
}
