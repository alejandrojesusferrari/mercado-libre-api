package com.mpapi.model.DTOs.TrademarksResponse;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.mpapi.model.beans.Trademark;
import com.mpapi.model.beans.Trademarks;

public class TrademarksResponseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5328930531985221058L;
	
	HashMap<String, TrademarksAveragesDTO> averagePrices;

	
	
	public HashMap<String, TrademarksAveragesDTO> getAveragePrices() {
		return averagePrices;
	}


	public void setAveragePrices(HashMap<String, TrademarksAveragesDTO> averagePrices) {
		this.averagePrices = averagePrices;
	}


	public TrademarksResponseDTO(Trademarks trademarks) {
		this.averagePrices= new HashMap<String, TrademarksAveragesDTO>();
		this.populatePrices(trademarks);
	}


	private void populatePrices(Trademarks trademarks) {
		HashMap<String, Trademark> trademarksInfo = trademarks.getTrademarks();
		
		for (Map.Entry<String, Trademark> entry : trademarksInfo.entrySet()) {
		    String key = entry.getKey();
		    Trademark value = entry.getValue();
		    
		    value.calculateAveragePrices();
		    averagePrices.put(key, new TrademarksAveragesDTO(value.getAvgARS(), value.getAvgUSD()));
		    

		}

	}
	
	
}
