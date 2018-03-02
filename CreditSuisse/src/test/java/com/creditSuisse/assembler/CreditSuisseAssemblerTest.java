package com.creditSuisse.assembler;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.creditSuisse.entities.Events;
import com.creditSuisse.entities.StateEnum;
import com.creditSuisse.form.ApplicationLog;
import com.creditSuisse.form.CreditSuisseForm;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class CreditSuisseAssemblerTest {
	
	@InjectMocks
	CreditSuisseAssembler creditSuisseAssembler;
	
	
	@Test
	public void shouldMapEvents(){
		//given
		CreditSuisseForm form = formWithApplicationLog();
		//when
		Events mapEvent = creditSuisseAssembler.mapEvent(form, 4l);
		//then
		assertThat(mapEvent.getEventDuration()).isEqualTo(4l);
		assertThat(mapEvent.getEventIdentifer()).isEqualTo("scsmbstgrb");
		assertThat(mapEvent.getApplicationLog().getHost()).isEqualTo("12345");
		assertThat(mapEvent.getApplicationLog().getType()).isEqualTo("APPLICATION_LOG");
		assertThat(mapEvent.isAlert()).isEqualTo(false);
	}
	
	@Test
	public void shouldReturnAlertAsTrue(){
		//given
		CreditSuisseForm form = formWithApplicationLog();
		//when
		Events mapEvent = creditSuisseAssembler.mapEvent(form, 6l);
		//then
		assertThat(mapEvent.getEventDuration()).isEqualTo(6l);
		assertThat(mapEvent.isAlert()).isEqualTo(true);
	}
	
	@Test
	public void shouldReturnNullWhenApplicationLogIsEmpty(){
		//given
		CreditSuisseForm form = formWithEmptyApplicationLog();
		//when
		Events mapEvent = creditSuisseAssembler.mapEvent(form, 6l);
		//then
		assertThat(mapEvent.getApplicationLog().getHost()).isEqualTo(null);
		assertThat(mapEvent.getApplicationLog().getType()).isEqualTo(null);
	}


	private CreditSuisseForm formWithApplicationLog() {
		CreditSuisseForm form =new CreditSuisseForm();
		form.setId("scsmbstgrb");
		ApplicationLog applicationLog = new ApplicationLog();
		applicationLog.setHost("12345");
		applicationLog.setType("APPLICATION_LOG");
		form.setApplicationLog(applicationLog);
		return form;
	}
	
	private CreditSuisseForm formWithEmptyApplicationLog() {
		CreditSuisseForm form =new CreditSuisseForm();
		form.setId("scsmbstgrb");		
		return form;
	}
}
