package coop.tecso.examen.dto;


import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;



public class AcountDto {

	private long id;
	@NotNull
	private long acountNro;
	private Double saldo;
	private List<MovementDto> movements = new ArrayList<MovementDto>();
	@NotNull
	private CurrencyDto currency = new CurrencyDto();
	public AcountDto() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public long getAcountNro() {
		return this.acountNro;
	}
	public void setAcountNro(long nro) {
		this.acountNro = nro;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public void setMovement(MovementDto movement) {
		this.movements.add(movement);
		
	}
	
	public List<MovementDto> getMovements()
	{
		return movements; 
	}
	public void setCurrency(String c) {
		this.currency.setCurrency(c);
	}
	public CurrencyDto getCurrency() {
		return this.currency;
	}
}
