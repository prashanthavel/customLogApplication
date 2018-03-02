package com.creditSuisse.assembler;

import org.springframework.stereotype.Component;

import com.creditSuisse.entities.Events;
import com.creditSuisse.form.CreditSuisseForm;

@Component
public class CreditSuisseAssembler {
	
	public Events mapEvent(CreditSuisseForm form, Long duration){
		Events event = new Events();
		event.setEventIdentifer(form.getId());
		event.setEventDuration(duration);
		event.setAlert(duration > 4 ? true : false);
		form.getApplicationLog().ifPresent(appLogForm -> {
			event.getApplicationLog().setHost(appLogForm.getHost());
			event.getApplicationLog().setType(appLogForm.getType());
		});
		return event;
		
	}
	
	
	public Events mapEvent1(CreditSuisseForm form){
		Events event = new Events();
		event.setEventIdentifer(form.getId());
		event.setEventDuration(form.getTimeStamp());
		event.setAlert(form.getTimeStamp() > 4 ? true : false);
		form.getApplicationLog().ifPresent(appLogForm -> {
			event.getApplicationLog().setHost(appLogForm.getHost());
			event.getApplicationLog().setType(appLogForm.getType());
		});
		return event;
		
	}

}
