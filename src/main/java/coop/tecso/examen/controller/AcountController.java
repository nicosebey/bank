package coop.tecso.examen.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coop.tecso.examen.dto.AcountDto;
import coop.tecso.examen.dto.CurrencyDto;
import coop.tecso.examen.dto.MovementDto;
import coop.tecso.examen.model.Acount;
import coop.tecso.examen.model.Movement;
import coop.tecso.examen.service.AcountService;

@RestController
@RequestMapping("/acount")
public class AcountController {
	
	@Autowired
	public AcountService acountService;
	
	
@PostMapping("/")	
public void createAcount(@RequestBody AcountDto acount) {
	 acountService.createAcount(acount.getSaldo(), acount.getCurrency().getCurrency());	
}



@PostMapping("/{id}/movement")
public void addMovement(@PathVariable("id") Long id, @RequestBody MovementDto movement ) {
	
	acountService.addMovement(id,movement.getType(),movement.getDescription(), movement.getSaldo());
}


@GetMapping("/")
public List<AcountDto> getAcounts(){
	List<Acount>acounts = acountService.getAcounts();
	List<AcountDto>result = new ArrayList<AcountDto>();
	for (Acount entity :acounts ) {
		AcountDto dto = new AcountDto();
		dto.setSaldo(entity.getSaldo());
		dto.setId(entity.getId());
		CurrencyDto currencyDto= new CurrencyDto();
		currencyDto.setCurrency(entity.getCurrency().getCurrency());
		dto.setCurrency(currencyDto.getCurrency());
		for (Movement m :entity.getMovements()){
			MovementDto mDto = new MovementDto();
			mDto.setType(m.getType());
			mDto.setAmount(m.getAmount());
			mDto.setDescription(m.getDescription());
			mDto.setDate(m.getDate());
			dto.setMovement(mDto);
		}
		result.add(dto);
	}
	return result;
}

@GetMapping("/{id}/movement")
public List<MovementDto> getMovements(@PathVariable("id") Long id){
	List<Movement> moves = acountService.getAcountMoves(id);
	List<MovementDto>result = new ArrayList<MovementDto>();
	for (Movement m :moves){
		MovementDto mDto = new MovementDto();
		mDto.setType(m.getType());
		mDto.setAmount(m.getAmount());
		mDto.setDescription(m.getDescription());
		mDto.setDate(m.getDate());
		result.add(mDto);
	}
	return result;
}

@DeleteMapping("/{id}")
public void deleteAcount(@PathVariable("id") Long id) {
	acountService.deleteAcount(id);
}
}
