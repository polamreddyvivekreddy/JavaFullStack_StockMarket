package com.example.stockAppCompanyDetails.shared;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyRequestModelEntity {
	private String companyName;
    private String companyCEO;
    private String companyTurnover;
    private String companyBoardOfDirectors;
    private String companySector;
    private String companyBriefWriteUp;
}
