package coop.tecso.examen.service.impl;

import coop.tecso.examen.model.Acount;
import coop.tecso.examen.model.Movement;

public interface Strategy {
	
	public boolean hasMoney(Acount a, Movement m);
}
