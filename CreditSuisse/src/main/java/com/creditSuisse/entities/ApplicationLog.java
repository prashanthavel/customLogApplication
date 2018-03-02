package com.creditSuisse.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ApplicationLog implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name = "TYPE")
	protected String type;

	@Column(name = "HOST_NAME")
	protected String host;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}
	
	
	
}
