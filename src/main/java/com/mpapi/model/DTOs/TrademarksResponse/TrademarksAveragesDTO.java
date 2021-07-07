package com.mpapi.model.DTOs.TrademarksResponse;

import java.io.Serializable;


public class TrademarksAveragesDTO implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8447622851586845887L;


	private Double avgARS;
	
	private Double avgUSD;

	public TrademarksAveragesDTO(Double avgARS, Double avgUSD) {
		this.avgARS = avgARS;
		this.avgUSD = avgUSD;

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

	

	
	
	
}
