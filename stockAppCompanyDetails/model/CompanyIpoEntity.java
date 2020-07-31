package com.example.stockAppCompanyDetails.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class CompanyIpoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer companyIpoId;
    private String companyIpoName;
    private String companyIpoTurnover;
    private String companyIpoShares;
    private String companyIpoStockExchange;

}
