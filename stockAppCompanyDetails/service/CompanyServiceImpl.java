package com.example.stockAppCompanyDetails.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.example.stockAppCompanyDetails.dao.CompanyRepository;
import com.example.stockAppCompanyDetails.dto.CompanyDto;
import com.example.stockAppCompanyDetails.exception.CompanyNotFoundException;
import com.example.stockAppCompanyDetails.model.CompanyEntity;
import com.example.stockAppCompanyDetails.shared.CompanyResponseModelEntity;

@Service
@EnableTransactionManagement
public class CompanyServiceImpl implements CompanyService {
    private CompanyRepository companyRepository;
    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }
    @Override
    @Transactional
    public CompanyResponseModelEntity createCompany(CompanyDto companyDto) {
//        companyDto.setCompanyId();
        ModelMapper mapper=new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        CompanyEntity companyEntity=mapper.map(companyDto,CompanyEntity.class);
        companyRepository.save(companyEntity);
        return mapper.map(companyEntity,CompanyResponseModelEntity.class);
    }
    
    @Override
    @Transactional
    public Optional<CompanyEntity> findByCompanyId(Integer companyId) throws CompanyNotFoundException {
    	
      
//    return companyRepository.findByCompanyId(companyId).
    	  return Optional.of(companyRepository.findByCompanyId(companyId).orElseThrow(() -> new CompanyNotFoundException("Exception occurred")));
    }

    @Override
    @Transactional
    public CompanyEntity findByCompanyName(String companyName) {
        return companyRepository.findByCompanyName(companyName);
    }
	@Override
	@Transactional
	public List<CompanyEntity> findByCompanyNameStartingWith(String pattern) {

		return companyRepository.findByCompanyNameStartingWith(pattern);
	}
	@Override
	public List<CompanyEntity> findByCompanyNameContaining(String pattern) {
		// TODO Auto-generated method stub
		return companyRepository.findByCompanyNameContaining(pattern);
	}
	@Override
	public List<CompanyEntity> findAll() {
		// TODO Auto-generated method stub
		return companyRepository.findAll();
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

