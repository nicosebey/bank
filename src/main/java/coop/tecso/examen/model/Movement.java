package coop.tecso.examen.model;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Movement extends AbstractPersistentObject implements Comparable<Movement> {

	private String type;
	private  Date date;
	private String description;
	private Double amount;
	
	
	public Movement() {
		// TODO Auto-generated constructor stub
		this.date = new Date();
	}
	
	public Movement(String type, String description, /*Moneda moneda,*/ Double amount) {
		this.type = type;
		this.amount = amount;
		this.description = description;
		this.date = new Date();
	}
	
	public double getAmount() {
		// TODO Auto-generated method stub
		return amount;
	}
	
	public String getDescription() {
		return description;
	}

	public String getType() {
		// TODO Auto-generated method stub
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int compareTo(Movement o) {
		// TODO Auto-generated method stub
		return o.date.compareTo(this.date);
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getDate() {
		// TODO Auto-generated method stub
		return this.date;
	}

}
