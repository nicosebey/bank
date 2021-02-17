package coop.tecso.examen.service.impl;


import java.util.HashMap;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coop.tecso.examen.model.Acount;
import coop.tecso.examen.model.Movement;
import coop.tecso.examen.repository.AcountRepository;
import coop.tecso.examen.service.AcountService;
import exceptions.AcountNotFound;
import exceptions.IlegalAccountDelete;
import exceptions.InsufficientAccountParams;
import exceptions.InsufficientFunds;

@Service
public class AcountServiceImpl implements AcountService {
	
	@Autowired
	private AcountRepository acountRepository;
	
	HashMap<String,Strategy> monedas = new HashMap<String,Strategy>();
	
public AcountServiceImpl() {
	// TODO Auto-generated constructor stub
	monedas.put("peso", new Funds(1000.00));
	monedas.put("euro", new Funds(150.00));
	monedas.put("dolar", new Funds(300.00));
}
@Override
public void addMovement(Long id,String type, String description, Double saldo) {
	Acount account = acountRepository.findByAcountNro(id);
	if (account == null) {
		throw new AcountNotFound("The account with id "+id+" doesnt exists");
	}
	Movement movement = new Movement();
	movement.setAmount(saldo);
	movement.setDescription(description);
	movement.setType(type);
	System.out.println(description);
	if (type.equals("credit") && !(monedas.get(account.getCurrency().getCurrency()).hasMoney(account, movement))) {
		throw new InsufficientFunds("The acount has no funds to make this credit movement");
	}
	account.setMovement(movement);
	acountRepository.save(account);
	}
@Override
public void createAcount(Double saldo , String currency) {
	if(saldo == null || currency==null) {
		throw new InsufficientAccountParams("you must incert the saldo and the currency.");
	}
	// TODO Auto-generated method stub
	Acount acount = new Acount();
	acount.setSaldo(saldo);
	acount.setCurrency(currency);
	acountRepository.save(acount);
	}

@Override
public List<Acount> getAcounts() {
	// TODO Auto-generated method stub
	return acountRepository.findAll();
}

@Override
@Transactional
public void deleteAcount(Long id) {
	// TODO Auto-generated method stub
	Acount acount = acountRepository.findByAcountNro(id);
	if(acount.getMovements().isEmpty()) {
		acountRepository.deleteByAcountNro(id);
	} else {
		throw new IlegalAccountDelete("You are not able to delete an acount with movements.");
	}
}
@Override
public List<Movement> getAcountMoves(Long id) {
	// TODO Auto-generated method stub
	Acount account =acountRepository.findByAcountNro(id);
	if (account == null) {
		throw new AcountNotFound("The account with id "+id+" doesnt exists");
	}
	return account.getMovements();
}
}
