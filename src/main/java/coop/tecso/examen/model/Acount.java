package coop.tecso.examen.model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.google.common.base.Objects;

@Entity
public class Acount extends AbstractPersistentObject {
	
	/**
	 * 
	 */
	private  double saldo;
	@OneToMany(cascade=CascadeType.ALL)
	private List<Movement> movements = new ArrayList<Movement>();
	@ManyToOne(cascade=CascadeType.ALL)
	private Currency currency = new Currency();
	private long acountNro;
	 
	public Acount() {
		this.saldo = 0.00;
		this.acountNro = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
	}
	
	public long getAcountNro() {
		return this.acountNro;
	}
	

	public void setMovement(Movement movement) {
		movements.add(movement);
		if (Objects.equal(movement.getType(),"credit")){
			saldo -= movement.getAmount();
		} else {
			saldo += movement.getAmount();
		}
	}
	
	public List<Movement> getMovements(){
		Collections.sort(movements);
		return movements;
	}
	
	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void setCurrency(String currency) {
		this.currency.setCurrency(currency);
	}
	
	public Currency getCurrency() {
		return this.currency;
	}
}
