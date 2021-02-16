package coop.tecso.examen.dto;


import java.util.ArrayList;
import java.util.List;

public class AcountDto {

	private long id;
	private Double saldo;
	private List<MovementDto> movements = new ArrayList<MovementDto>();
	private CurrencyDto currency = new CurrencyDto();
	public AcountDto() {
		// TODO Auto-generated constructor stub
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
