package com.mpapi.model.beans;

import java.io.Serializable;
import java.util.ArrayList;

import com.mpapi.model.DTOs.MLResponse.ResultDTO;

public class Trademark implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5692343408300720070L;

	private String marca;
	
	private ArrayList<MotorcyclePost> posts;
	
	private Double avgARS;
	
	private Double avgUSD;

	
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public ArrayList<MotorcyclePost> getPosts() {
		return posts;
	}

	public void setPosts(ArrayList<MotorcyclePost> posts) {
		this.posts = posts;
	}

	public Double getAvgARS() {
		return avgARS;
	}

	public void setAvgARS(Double avgARS) {
		this.avgARS = avgARS;
	}

	public Double getAvgUSD() {
		return avgUSD;
	}

	public void setAvgUSD(Double avgUSD) {
		this.avgUSD = avgUSD;
	}

	public void addMotorcyclePost(ResultDTO resultDTO) {
			
		if (posts==null) {
			posts = new ArrayList<MotorcyclePost>();
		}
		posts.add(new MotorcyclePost(resultDTO.getId(), resultDTO.getTitle(), resultDTO.getCurrency_id(), resultDTO.getPrice(), resultDTO.getCondition()));

		
	}

	public void calculateAveragePrices() {
		Double sumArs = (double) 0;
		Double countArs = (double) 0;
		Double sumUSD = (double) 0;
		Double countUSD = (double) 0;

		if (posts!=null && !posts.isEmpty()) {
			for (MotorcyclePost motorcyclePost : posts) {
				if (motorcyclePost.getCurrency_id().equals("ARS") && motorcyclePost.getIsNew()) {
					sumArs= sumArs + motorcyclePost.getPrice();
					countArs= countArs + 1;

				} else if (motorcyclePost.getCurrency_id().equals("USD") && motorcyclePost.getIsNew()) {
					sumUSD= sumUSD + motorcyclePost.getPrice();
					countUSD= countUSD + 1;

				}
				
			}
			
		}
		if (countArs!=0) {
			this.avgARS = sumArs/countArs;
		} else {
			this.avgARS = (double) 0;
		}
		if (countUSD!=0) {
			this.avgUSD = sumUSD/countUSD;
		} else {
			this.avgUSD = (double) 0;
		}


	}
	

}
