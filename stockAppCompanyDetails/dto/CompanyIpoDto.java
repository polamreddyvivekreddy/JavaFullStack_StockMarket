package com.example.stockAppCompanyDetails.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class CompanyIpoDto {
	
    private Integer companyIpoId;
    private String companyIpoName;
    private String companyIpoTurnover;
    private String companyIpoShares;
    private String companyIpoStockExchange;
    
    
    
    
	public CompanyIpoDto() {
	}


	public CompanyIpoDto(Integer companyIpoId, String companyIpoName, String companyIpoTurnover,
			String companyIpoShares, String companyIpoStockExchange) {
		super();
		this.companyIpoId = companyIpoId;
		this.companyIpoName = companyIpoName;
		this.companyIpoTurnover = companyIpoTurnover;
		this.companyIpoShares = companyIpoShares;
		this.companyIpoStockExchange = companyIpoStockExchange;
	}
	
	
	public Integer getCompanyIpoId() {
		return companyIpoId;
	}
	public void setCompanyIpoId(Integer companyIpoId) {
		this.companyIpoId = companyIpoId;
	}
	public String getCompanyIpoName() {
		return companyIpoName;
	}
	public void setCompanyIpoName(String companyIpoName) {
		this.companyIpoName = companyIpoName;
	}
	public String getCompanyIpoTurnover() {
		return companyIpoTurnover;
	}
	public void setCompanyIpoTurnover(String companyIpoTurnover) {
		this.companyIpoTurnover = companyIpoTurnover;
	}
	public String getCompanyIpoShares() {
		return companyIpoShares;
	}
	public void setCompanyIpoShares(String companyIpoShares) {
		this.companyIpoShares = companyIpoShares;
	}
	public String getCompanyIpoStockExchange() {
		return companyIpoStockExchange;
	}
	public void setCompanyIpoStockExchange(String companyIpoStockExchange) {
		this.companyIpoStockExchange = companyIpoStockExchange;
	}

    
}