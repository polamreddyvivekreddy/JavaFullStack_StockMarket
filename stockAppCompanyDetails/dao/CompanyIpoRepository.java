package com.example.stockAppCompanyDetails.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.stockAppCompanyDetails.model.CompanyEntity;
import com.example.stockAppCompanyDetails.model.CompanyIpoEntity;

@Repository
public interface CompanyIpoRepository extends CrudRepository<CompanyIpoEntity, Integer> {
	
    public CompanyIpoEntity findByCompanyIpoId(Integer companyIpoId);
    public CompanyIpoEntity findByCompanyIpoName(String companyIpoName);

}
