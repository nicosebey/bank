package coop.tecso.examen.service;

import java.util.List;

import coop.tecso.examen.model.Acount;
import coop.tecso.examen.model.Movement;


public interface AcountService {

	public void createAcount(Double saldo, String currency);

	public void addMovement(Long id,String type, String description, Double saldo);

	public List<Acount> getAcounts();
	
	public void deleteAcount(Long id);

	public List<Movement> getAcountMoves(Long id);
	
}
