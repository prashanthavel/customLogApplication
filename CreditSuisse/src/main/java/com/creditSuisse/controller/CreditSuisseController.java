package com.creditSuisse.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.creditSuisse.entities.Events;
import com.creditSuisse.form.CreditSuisseForm;
import com.creditSuisse.service.CreditSuisseService;

@RestController
@RequestMapping("/api/creditSuisse")
public class CreditSuisseController {
	
	private CreditSuisseService creditSuisseService;
		
	@Autowired
	public CreditSuisseController(CreditSuisseService creditSuisseService){
		this.creditSuisseService = creditSuisseService;
	}
	
	@RequestMapping(method = {RequestMethod.POST})
	public void saveEvent(@Valid @RequestBody List<CreditSuisseForm> forms){
		creditSuisseService.saveEvents(forms);
	}
	
	@RequestMapping(value = "/{id}",method = {RequestMethod.GET})
	public Events getEvent(@PathVariable("id")Integer id){
		return creditSuisseService.getEvent(id);
	}
	
	@RequestMapping(method = {RequestMethod.GET})
	public List<Events> getAllEvents(){
		return creditSuisseService.getAllEvent();
	}
	
}
