package com.creditSuisse.form;

import java.util.Comparator;
import java.util.Optional;

import com.creditSuisse.entities.StateEnum;

public class CreditSuisseForm implements Comparable<CreditSuisseForm>{

	private String id;
	private StateEnum state;
	private Long timeStamp;
	private ApplicationLog applicationLog;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public StateEnum getState() {
		return state;
	}
	public void setState(StateEnum state) {
		this.state = state;
	}
	public Long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}
	public Optional<ApplicationLog> getApplicationLog() {
		return Optional.ofNullable(applicationLog);
	}
	public void setApplicationLog(ApplicationLog applicationLog) {
		this.applicationLog = applicationLog;
	}
	@Override
	public int compareTo(CreditSuisseForm o) {
		return Comparator.comparing(CreditSuisseForm :: getId)
				.thenComparing(CreditSuisseForm :: getTimeStamp)
				.compare(this, o);
	}

}
