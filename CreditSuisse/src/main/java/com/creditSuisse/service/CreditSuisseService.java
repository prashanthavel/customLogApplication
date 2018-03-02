package com.creditSuisse.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.creditSuisse.assembler.CreditSuisseAssembler;
import com.creditSuisse.dao.CreditSuisseDao;
import com.creditSuisse.entities.Events;
import com.creditSuisse.form.CreditSuisseForm;
import com.creditSuisse.form.CreditSuisseFormComparator;

@Service
public class CreditSuisseService {

	@Autowired
	private CreditSuisseDao creditSuisseDao;
	@Autowired
	private CreditSuisseAssembler assembler;
	
	private static String name ="";
	private static Long duration = 0L;
	
	public void saveEvents(List<CreditSuisseForm> creditSuisseForms) {
		
		Collections.sort(creditSuisseForms,new CreditSuisseFormComparator());  
		creditSuisseForms.stream().forEach(creditSuisseForm -> {
			if(!StringUtils.isEmpty(name)  && name.equalsIgnoreCase(creditSuisseForm.getId())){
				duration = creditSuisseForm.getTimeStamp() - duration;
				Events mapEvent = assembler.mapEvent(creditSuisseForm,duration);
				creditSuisseDao.save(mapEvent);
			}else{
				duration  = creditSuisseForm.getTimeStamp();
				name = creditSuisseForm.getId();
			}
		});
	}
	
	
	public Events getEvent(Integer id) {
		return creditSuisseDao.findOne(id);
	}
	
	
	public List<Events> getAllEvent() {
		return (List<Events>) creditSuisseDao.findAll();
	}

}
