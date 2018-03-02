package com.creditSuisse.entities;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.Table;

@Entity
@Table(name="event")
public class Events {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Column(name="event_Identifer")
	private String eventIdentifer;
	
	@Column(name="event_duration")
	private Long eventDuration;
	
    @Embedded
    private ApplicationLog applicationLog;
    private boolean alert;
    
    @PostLoad
	protected final void init(){
		if (this.applicationLog == null) {
			this.applicationLog = new ApplicationLog();
		}
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer eventId) {
		this.id = eventId;
	}
	public String getEventIdentifer() {
		return eventIdentifer;
	}
	public void setEventIdentifer(String eventIdentifer) {
		this.eventIdentifer = eventIdentifer;
	}

	public Long getEventDuration() {
		return eventDuration;
	}
	public void setEventDuration(Long eventDuration) {
		this.eventDuration = eventDuration;
	}
	public ApplicationLog getApplicationLog() {
		 if (applicationLog == null)
			 applicationLog = new ApplicationLog();
	        return applicationLog;
	}
	public void setApplicationLog(ApplicationLog applicationLog) {
		this.applicationLog = applicationLog;
	}
	public boolean isAlert() {
		return alert;
	}
	public void setAlert(boolean alert) {
		this.alert = alert;
	}
}
