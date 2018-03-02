package com.creditSuisse.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.creditSuisse.assembler.CreditSuisseAssembler;
import com.creditSuisse.dao.CreditSuisseDao;
import com.creditSuisse.entities.Events;
import com.creditSuisse.form.CreditSuisseForm;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class CreditSuisseServiceTest {
	
	
	@InjectMocks
	CreditSuisseService creditSuisseService;
	@Mock
	private CreditSuisseDao creditSuisseDao;
	@Mock
	private CreditSuisseAssembler assembler;
	
	@Test
	public void shouldNotSave()
	{
		//given
		List<CreditSuisseForm> creditSuisseForms = new ArrayList<CreditSuisseForm>();
		CreditSuisseForm e = new CreditSuisseForm();
		creditSuisseForms.add(e);
		//when
		creditSuisseService.saveEvents(creditSuisseForms);
		//then
		verify(creditSuisseDao, times(0)).save(any(Events.class));
	}
	
	
	@Test
	public void shouldSaveOnlyOnce()
	{
		//given
		List<CreditSuisseForm> creditSuisseForms = new ArrayList<CreditSuisseForm>();
		CreditSuisseForm e = new CreditSuisseForm();
		e.setId("scsmbstgra");
		e.setTimeStamp(1491377495212l);
		creditSuisseForms.add(e);
		CreditSuisseForm e1 = new CreditSuisseForm();
		e1.setId("scsmbstgra");
		e1.setTimeStamp(1491377495217l);
		creditSuisseForms.add(e1);
		//when
		creditSuisseService.saveEvents(creditSuisseForms);
		//then
		verify(creditSuisseDao, times(1)).save(any(Events.class));
	}
	
	
	@Test
	public void shouldSaveTwice()
	{
		//given
		List<CreditSuisseForm> creditSuisseForms = new ArrayList<CreditSuisseForm>();
		CreditSuisseForm e = new CreditSuisseForm();
		e.setId("scsmbstgra");
		e.setTimeStamp(1491377495212l);
		creditSuisseForms.add(e);
		CreditSuisseForm e1 = new CreditSuisseForm();
		e1.setId("scsmbstgra");
		e1.setTimeStamp(1491377495217l);
		creditSuisseForms.add(e1);
		
		CreditSuisseForm e2 = new CreditSuisseForm();
		e2.setId("scsmbstgrb");
		e2.setTimeStamp(1491377495213l);
		creditSuisseForms.add(e2);
		CreditSuisseForm e3 = new CreditSuisseForm();
		e3.setId("scsmbstgrb");
		e3.setTimeStamp(1491377495216l);
		creditSuisseForms.add(e3);
		//when
		creditSuisseService.saveEvents(creditSuisseForms);
		//then
		verify(creditSuisseDao, times(2)).save(any(Events.class));
	}

}
