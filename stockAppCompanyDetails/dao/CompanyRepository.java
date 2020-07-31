package com.example.stockAppCompanyDetails.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.example.stockAppCompanyDetails.dto.CompanyDto;
import com.example.stockAppCompanyDetails.model.CompanyEntity;

import com.example.stockAppCompanyDetails.shared.CompanyResponseModelEntity;

@Repository
public interface CompanyRepository extends CrudRepository<CompanyEntity,Integer> {
	
    public Optional<CompanyEntity> findByCompanyId(Integer companyId);
    public CompanyEntity findByCompanyName(String companyName);
    public List<CompanyEntity> findByCompanyNameStartingWith(String pattern);
    public List<CompanyEntity> findByCompanyNameContaining(String pattern);
    public List<CompanyEntity> findAll();
    
	

	
	
    
//    public CompanyEntity findByUserIdAndEmail(String userId, String email);
//    public CompanyEntity findByUserIdOrEmail(String userId, String email);

}

