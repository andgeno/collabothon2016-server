package de.comdirect.collabothon2016.depotengine.data;

import javax.validation.constraints.NotNull;

public class DepotuserCredentials {

	@NotNull
	private String zugangsnummer;
	
	@NotNull
	private String pin;
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
