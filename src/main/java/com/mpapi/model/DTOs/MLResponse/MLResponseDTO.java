package com.mpapi.model.DTOs.MLResponse;

import java.util.ArrayList;

public class MLResponseDTO {
    
	private String site_id;
	private ArrayList<ResultDTO> results;
	private PagingDTO paging;
	
	public String getSite_id() {
		return site_id;
	}
	public void setSite_id(String site_id) {
		this.site_id = site_id;
	}
	public ArrayList<ResultDTO> getResults() {
		return results;
	}
	public void setResults(ArrayList<ResultDTO> results) {
		this.results = results;
	}
	public PagingDTO getPaging() {
		return paging;
	}
	public void setPaging(PagingDTO paging) {
		this.paging = paging;
	}
	public void merge(MLResponseDTO mlResponseDTO) {
		this.paging=mlResponseDTO.getPaging();
		this.results.addAll(mlResponseDTO.getResults());


		
	}

	
	
}
