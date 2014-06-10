package com.soarsky.octopus.clientuser.vo;


public class ExchangeMsg {
	public String details;
	public ExchangeMsg(){
		
	}
	public ExchangeMsg(String details, Long id) {
		super();
		this.details = details;
		this.id = id;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long id;
}
