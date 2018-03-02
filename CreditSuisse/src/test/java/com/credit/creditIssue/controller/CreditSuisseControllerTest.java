package com.credit.creditIssue.controller;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.verification.Times;
import org.mockito.runners.MockitoJUnitRunner;

import com.creditSuisse.controller.CreditSuisseController;
import com.creditSuisse.form.CreditSuisseForm;
import com.creditSuisse.service.CreditSuisseService;

@RunWith(MockitoJUnitRunner.class)
public class CreditSuisseControllerTest {
	
	@Mock
	private CreditSuisseService creditSuisseService;
	
	@InjectMocks
	private CreditSuisseController controller;
	final static Integer event_id = 12345;
	@Before
	public void setup(){
		controller = new CreditSuisseController(creditSuisseService);
	}

	@Test
	public void shouldSaveEvents(){
		//given 
		List<CreditSuisseForm> forms = new ArrayList<>();
		CreditSuisseForm form = new CreditSuisseForm();
		forms.add(form);
		
		//when
		controller.saveEvent(forms);
		
		//then
		Mockito.verify(creditSuisseService).saveEvents(forms);
	}
	
	@Test
	public void shouldGetEvent(){
		//when
		controller.getEvent(event_id);
		//then
		Mockito.verify(creditSuisseService).getEvent(any());
	}
	
	@Test
	public void shouldGetAllEvents(){
		//when
		controller.getAllEvents();
		//then
		verify(creditSuisseService, times(0)).getAllEvent();
	}

}
