package de.comdirect.collabothon2016.depotengine;

public interface DepotengineRestConnections {

	public static final String URL = "https://cdavmd01.northeurope.cloudapp.azure.com";
	public static final String URL_VOTING = "http://localhost:8081";
	public static final String URL_USER = "http://localhost:8090";
	
	public static final String PATH_LOGIN = "/api/v1/sicherheit/sessions";
	public static final String PATH_PORTFOLIO = "/api/v1/depotvw/depots/";
	public static final String PATH_NEW_ORDER = "/api/v1/depotta/wporders/";
	
	public static final String PATH_GET_VOTINGWINNER = "/voting/suggestions/winner/";
	
	public static final String PATH_GET_ATTENDIES = "/users";
}
