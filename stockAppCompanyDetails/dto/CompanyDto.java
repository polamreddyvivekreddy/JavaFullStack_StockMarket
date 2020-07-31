package com.example.stockAppCompanyDetails.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDto {
    private Integer companyId;
    private String companyName;
    private String companyCEO;
    private String companyTurnover;
    private String companyBoardOfDirectors;
    private String companySector;
    private String companyBriefWriteUp;
    
}
