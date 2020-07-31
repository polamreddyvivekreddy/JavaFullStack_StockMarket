package com.example.stockAppCompanyDetails.service;
import java.util.List;
import java.util.Optional;

import com.example.stockAppCompanyDetails.dto.CompanyDto;
import com.example.stockAppCompanyDetails.exception.CompanyNotFoundException;
import com.example.stockAppCompanyDetails.model.CompanyEntity;
import com.example.stockAppCompanyDetails.shared.CompanyResponseModelEntity;
public interface CompanyService {

    public CompanyResponseModelEntity createCompany(CompanyDto companyDto);
    public List<CompanyEntity> findAll();
    public Optional<CompanyEntity> findByCompanyId(Integer companyId) throws CompanyNotFoundException;
    public CompanyEntity findByCompanyName(String companyName);
    public List<CompanyEntity> findByCompanyNameStartingWith(String pattern);
    public List<CompanyEntity> findByCompanyNameContaining(String pattern);
    
//    public CompanyEntity findByUserIdAndEmail(String userId, String email);
//    public CompanyEntity findByUserIdOrEmail(String userId, String email);
}
