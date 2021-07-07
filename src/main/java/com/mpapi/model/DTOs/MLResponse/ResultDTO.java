package com.mpapi.model.DTOs.MLResponse;

import java.util.ArrayList;

public class ResultDTO {


	private String id;

	private String title;
	
	private String currency_id;
	
	private Double price;

	private String condition;

	private ArrayList<AttributeDTO> attributes;

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

	public ArrayList<AttributeDTO> getAttributes() {
		return attributes;
	}

	public void setAttributes(ArrayList<AttributeDTO> attributes) {
		this.attributes = attributes;
	}
	

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getTrademarkName() {


	     AttributeDTO attributeDTO = attributes.stream()
	            .filter(a -> a.getId().equals("ENGINE_MANUFACTURER"))
	            .findFirst()
	            .orElse(null);

	     if (attributeDTO!=null) {
			return attributeDTO.getValue_name();
		} else {
			return "N/A"; 
		}
	
	}

	
	
}
