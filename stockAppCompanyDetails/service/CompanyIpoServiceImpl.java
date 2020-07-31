package com.example.stockAppCompanyDetails.service;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.example.stockAppCompanyDetails.dao.CompanyIpoRepository;
import com.example.stockAppCompanyDetails.dao.CompanyRepository;
import com.example.stockAppCompanyDetails.dto.CompanyDto;
import com.example.stockAppCompanyDetails.dto.CompanyIpoDto;
import com.example.stockAppCompanyDetails.model.CompanyEntity;
import com.example.stockAppCompanyDetails.model.CompanyIpoEntity;
import com.example.stockAppCompanyDetails.shared.CompanyIpoResponseModelEntity;
import com.example.stockAppCompanyDetails.shared.CompanyResponseModelEntity;

@Service
@EnableTransactionManagement
public class CompanyIpoServiceImpl implements CompanyIpoService {
    private CompanyIpoRepository companyIpoRepository;
    @Autowired
    public CompanyIpoServiceImpl(CompanyIpoRepository companyIpoRepository) {
        this.companyIpoRepository = companyIpoRepository;
    }
    @Override
    @Transactional
    public CompanyIpoResponseModelEntity createCompanyIpo(CompanyIpoDto companyIpoDto) {
//        companyDto.setCompanyId();
        ModelMapper mapper=new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        CompanyIpoEntity companyIpoEntity=mapper.map(companyIpoDto,CompanyIpoEntity.class);
        companyIpoRepository.save(companyIpoEntity);
        return mapper.map(companyIpoEntity,CompanyIpoResponseModelEntity.class);
    }
    
    @Override
    @Transactional
    public CompanyIpoEntity findByCompanyIpoId(Integer companyIpoId) {
        return companyIpoRepository.findByCompanyIpoId(companyIpoId);
    }

    @Override
    @Transactional
    public CompanyIpoEntity findByCompanyIpoName(String companyIpoName) {
        return companyIpoRepository.findByCompanyIpoName(companyIpoName);
    }

    
    
    
//	@Override
//	@Transactional
//	public CompanyEntity findByUserIdAndEmail(String userId, String email) {
//		return  companyRepository.findByUserIdAndEmail(userId, email);
//	}
//	@Override
//	public CompanyEntity findByUserIdOrEmail(String userId, String email) {
//		return companyRepository.findByUserIdOrEmail(userId, email);
//	}
	
	}

