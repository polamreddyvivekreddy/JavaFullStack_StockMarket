package com.example.stockAppCompanyDetails.service;
import com.example.stockAppCompanyDetails.dto.CompanyDto;
import com.example.stockAppCompanyDetails.dto.CompanyIpoDto;
import com.example.stockAppCompanyDetails.model.CompanyEntity;
import com.example.stockAppCompanyDetails.model.CompanyIpoEntity;
import com.example.stockAppCompanyDetails.shared.CompanyIpoResponseModelEntity;
import com.example.stockAppCompanyDetails.shared.CompanyResponseModelEntity;
public interface CompanyIpoService {

    public CompanyIpoResponseModelEntity createCompanyIpo(CompanyIpoDto companyIpoDto);
    public CompanyIpoEntity findByCompanyIpoId(Integer companyIpoId);
    public CompanyIpoEntity findByCompanyIpoName(String companyIpoName);
//    public CompanyEntity findByUserIdAndEmail(String userId, String email);
//    public CompanyEntity findByUserIdOrEmail(String userId, String email);
}
