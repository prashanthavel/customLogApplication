package com.creditSuisse.form;

import java.io.Serializable;

public class ApplicationLog implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String type;
	private String host;
	
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
