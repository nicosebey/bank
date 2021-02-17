package coop.tecso.examen.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MovementDto {
	@NotNull
	private String type;
	@NotNull
	@Size(max=200)
	private String description;
	//private Moneda moneda;
	private Double amount;
	private Date date;
	
	public MovementDto() {
		// TODO Auto-generated constructor stub
	}

	public String getType() {
		// TODO Auto-generated method stub
		return type;
	}

	public Double getSaldo() {
		// TODO Auto-generated method stub
		return amount;
	}

	public String getDescription() {
		// TODO Auto-generated method stub
		return description;
	}

	public void setType(String type2) {
		// TODO Auto-generated method stub
		this.type = type2;
		
	}

	public void setDescription(String description2) {
		this.description = description2;		
	}

	public void setAmount(Double amount2) {
		this.amount = amount2;
		
	}
	
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date2) {
		// TODO Auto-generated method stub
		this.date = date2;
	}

}
