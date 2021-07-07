package com.mpapi.model.DTOs.MLResponse;

public class PagingDTO {

    private Integer total;
    private Integer primary_results;
    private Integer offset;
    private Integer limit;
	
    public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getPrimary_results() {
		return primary_results;
	}
	public void setPrimary_results(Integer primary_results) {
		this.primary_results = primary_results;
	}
	public Integer getOffset() {
		return offset;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
 
    
    

}
