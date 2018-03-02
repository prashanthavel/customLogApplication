package com.creditSuisse.dao;

import org.springframework.data.repository.CrudRepository;

import com.creditSuisse.entities.Events;

public interface CreditSuisseDao extends CrudRepository<Events, Integer>{

}
