package coop.tecso.examen.controller;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.verification.Times;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import coop.tecso.examen.model.Acount;
import coop.tecso.examen.repository.AcountRepository;
import coop.tecso.examen.service.AcountService;

@RunWith(SpringRunner.class)
@WebMvcTest(AcountService.class)
public class AccountControllerTest {
	
	
	@Autowired
	private AcountService accountController;
	
	 @MockBean
	private AcountRepository myRepository;
	 
	 @Test
	 public void getAccountsTest() {
		 when(myRepository.findAll()).thenReturn(Stream.of(new Acount(),new Acount(), new Acount()).collect(Collectors.toList())); 
		 assertEquals(3, accountController.getAcounts().size());
	 }
}
