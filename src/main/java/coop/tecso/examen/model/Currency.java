package coop.tecso.examen.model;

import javax.persistence.Entity;

@Entity
public class Currency extends AbstractPersistentObject{

	private String currency;
	
	
	public Currency() {
		// TODO Auto-generated constructor stub
	}

	public String getCurrency() {
		return this.currency;
	}
	
	public void setCurrency(String currency) {
		this.currency = currency;
		
	}
}
