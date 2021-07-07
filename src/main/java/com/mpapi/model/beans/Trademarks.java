package com.mpapi.model.beans;

import java.io.Serializable;
import java.util.HashMap;

import com.mpapi.model.DTOs.MLResponse.ResultDTO;

public class Trademarks implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2941584327717043593L;

	private HashMap<String, Trademark> trademarks;
	
	
	public HashMap<String, Trademark> getTrademarks() {
		return trademarks;
	}


	public void setTrademarks(HashMap<String, Trademark> trademarks) {
		this.trademarks = trademarks;
	}


	public void addItem(ResultDTO resultDTO) {
		
		
		if (trademarks==null) {
			trademarks = new HashMap<String, Trademark>();
		}
		Trademark trademark = trademarks.get(resultDTO.getTrademarkName());
		if (trademark!=null) {
			trademark.addMotorcyclePost(resultDTO);
		} else {
			trademark = new Trademark();
			trademark.addMotorcyclePost(resultDTO);
			trademarks.put(resultDTO.getTrademarkName(), trademark);
		}
	}
}
