package de.comdirect.collabothon2016.depotengine.data;

/**
 * {
   "orderTyp": "Einzelorder",
   "orderId": "1",
   "status": "OFFEN",
   "depotnr": "123456789000",
   "geschaeftsart": "K",
   "wertpapierId": "710000",
   "handelswert": "100",
   "ausfuehrungslimit": "82.00",
   "ausmachenderBetrag":    {
      "betrag": "8200.00",
      "waehrung": "EUR"
   },
   "ausfuehrungskurs": null
}
 * @author A4595419
 *
 */
public class NewOrderInformationFromServerTO {
	private String orderTyp;
	private String orderId;
	private String status;
	private String depotnr;
	private String geschaeftsart;
	private String wertpapierId;
	private double handelswert;
	private double ausfuehrungslimit;
	private Betrag ausmachenderBetrag;
	public String getOrderTyp() {
		return orderTyp;
	}
	public void setOrderTyp(String orderTyp) {
		this.orderTyp = orderTyp;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDepotnr() {
		return depotnr;
	}
	public void setDepotnr(String depotnr) {
		this.depotnr = depotnr;
	}
	public String getGeschaeftsart() {
		return geschaeftsart;
	}
	public void setGeschaeftsart(String geschaeftsart) {
		this.geschaeftsart = geschaeftsart;
	}
	public String getWertpapierId() {
		return wertpapierId;
	}
	public void setWertpapierId(String wertpapierId) {
		this.wertpapierId = wertpapierId;
	}
	public double getHandelswert() {
		return handelswert;
	}
	public void setHandelswert(double handelswert) {
		this.handelswert = handelswert;
	}
	public double getAusfuehrungslimit() {
		return ausfuehrungslimit;
	}
	public void setAusfuehrungslimit(double ausfuehrungslimit) {
		this.ausfuehrungslimit = ausfuehrungslimit;
	}
	public Betrag getAusmachenderBetrag() {
		return ausmachenderBetrag;
	}
	public void setAusmachenderBetrag(Betrag ausmachenderBetrag) {
		this.ausmachenderBetrag = ausmachenderBetrag;
	}
	
	
}
