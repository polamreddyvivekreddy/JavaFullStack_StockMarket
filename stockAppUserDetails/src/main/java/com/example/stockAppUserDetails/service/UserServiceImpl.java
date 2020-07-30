package com.example.stockAppUserDetails.service;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.example.stockAppUserDetails.dao.UserRepository;
import com.example.stockAppUserDetails.dto.UserDto;
import com.example.stockAppUserDetails.model.UserEntity;
import com.example.stockAppUserDetails.shared.UserResponseModelEntity;

@Service
@EnableTransactionManagement
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    @Transactional
    public UserResponseModelEntity createUser(UserDto userDto) {
//        companyDto.setCompanyId();
        ModelMapper mapper=new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserEntity userEntity=mapper.map(userDto,UserEntity.class);
        userRepository.save(userEntity);
        return mapper.map(userEntity,UserResponseModelEntity.class);
    }
    
    @Override
    @Transactional
    public UserEntity findByUserId(Integer userId) {
        return userRepository.findByUserId(userId);
    }

    @Override
    @Transactional
    public UserEntity findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
	@Override
	@Transactional
	public List<UserEntity> findByUserNameStartingWith(String pattern) {

		return userRepository.findByUserNameStartingWith(pattern);
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

