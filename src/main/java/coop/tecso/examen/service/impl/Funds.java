package coop.tecso.examen.service.impl;

import coop.tecso.examen.model.Acount;
import coop.tecso.examen.model.Movement;

public class Funds implements Strategy{

	private Double balance;
	
	@Override
	public boolean hasMoney(Acount a, Movement m) {
		System.out.println(a.getSaldo());
		System.out.println(m.getAmount());
		System.out.println(a.getSaldo() - m.getAmount());
		if ((a.getSaldo() - m.getAmount()) < -balance) {
			return false;
		}else {
			return true;
		}
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	public Double getBalance() {
		return this.balance;
	}
	public Funds(Double balance) {
		this.balance = balance;
	}

}
