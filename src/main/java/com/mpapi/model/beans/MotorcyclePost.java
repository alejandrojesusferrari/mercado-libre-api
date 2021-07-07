package com.mpapi.model.beans;

import java.io.Serializable;


public class MotorcyclePost implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8391310247207512640L;

	private String id;

	private String title;
	
	private String currency_id;
	
	private Double price;
	
	private Boolean isNew;
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getCurrency_id() {
		return currency_id;
	}


	public void setCurrency_id(String currency_id) {
		this.currency_id = currency_id;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}

	

	protected Boolean getIsNew() {
		return isNew;
	}


	protected void setIsNew(Boolean isNew) {
		this.isNew = isNew;
	}


	public MotorcyclePost(String id, String title, String currency_id, Double price, String condition) {
		
		this.id=id;
		this.title=title;
		this.currency_id= currency_id;
		this.price=price;
		if (condition!=null && condition.trim().toLowerCase().equals("new")) {
			isNew=true;
		} else {
			isNew=false;
		}
		
		
	}
	
	
	
}
