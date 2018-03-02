package com.creditSuisse.assembler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.creditSuisse.entities.Events;
import com.creditSuisse.form.CreditSuisseForm;

@Component
public class CreditSuisseAssembler {
	private static final Logger logger = LoggerFactory.getLogger(CreditSuisseAssembler.class);
	public Events mapEvent(CreditSuisseForm form, Long duration)
	{
		logger.info("Event Assembling has started : mapEvent() for Event_id " +form.getId());
		Events event = new Events();
		event.setEventIdentifer(form.getId());
		event.setEventDuration(duration);
		event.setAlert(duration > 4 ? true : false);
		form.getApplicationLog().ifPresent(appLogForm -> {
			event.getApplicationLog().setHost(appLogForm.getHost());
			event.getApplicationLog().setType(appLogForm.getType());
		});
		logger.info("Event Assembling is Completed for " +form.getId());
		return event;
		
	}
}
