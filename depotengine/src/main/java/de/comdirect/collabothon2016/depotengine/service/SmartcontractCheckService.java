package de.comdirect.collabothon2016.depotengine.service;

public class SmartcontractCheckService implements CheckService{

	public void check(){
		System.out.println(this.getClass().getName() + " fuehrt den Check durch");
	}
}
