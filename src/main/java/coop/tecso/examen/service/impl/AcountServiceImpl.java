package coop.tecso.examen.service.impl;


import java.util.HashMap;
import java.util.List;

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
import exceptions.InsufficientMovementParams;

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
	if (acountRepository.getOne(id) == null) {
		throw new AcountNotFound("The account with id "+id+" doesnt exists");
	}
	Acount acount = acountRepository.getOne(id);
	Movement movement = new Movement();
	movement.setAmount(saldo);
	movement.setDescription(description);
	movement.setType(type);
	System.out.println(description);
	if(saldo == null || description==null||type==null) {
		throw new InsufficientMovementParams("you must incert the type the description and saldo");
	}
	if (type.equals("credit") && !(monedas.get(acount.getCurrency().getCurrency()).hasMoney(acount, movement))) {
		throw new InsufficientFunds("The acount has no funds to make this credit movement");
	}
	acount.setMovement(movement);
	acountRepository.save(acount);
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
public void deleteAcount(Long id) {
	// TODO Auto-generated method stub
	Acount acount = acountRepository.getOne(id);
	if(acount.getMovements().isEmpty()) {
		acountRepository.deleteById(id);
	} else {
		throw new IlegalAccountDelete("You are not able to delete an acount with movements.");
	}
}
@Override
public List<Movement> getAcountMoves(Long id) {
	// TODO Auto-generated method stub
	if (acountRepository.getOne(id) == null) {
		throw new AcountNotFound("The account with id "+id+" doesnt exists");
	}
	return acountRepository.getOne(id).getMovements();
}
}
