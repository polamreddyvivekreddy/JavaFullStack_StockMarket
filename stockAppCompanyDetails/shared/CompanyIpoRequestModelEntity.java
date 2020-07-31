package com.example.stockAppCompanyDetails.shared;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyIpoRequestModelEntity {
	private Integer companyIpoId;
    private String companyIpoName;
    private String companyIpoTurnover;
    private String companyIpoShares;
    private String companyIpoStockExchange;
}
