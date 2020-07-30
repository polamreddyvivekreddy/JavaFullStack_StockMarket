package com.example.stockAppUserDetails.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.stockAppUserDetails.model.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity,Integer> {
	
    public UserEntity findByUserId(Integer userId);
    public UserEntity findByUserName(String userName);
    public List<UserEntity> findByUserNameStartingWith(String pattern);
    
//    public CompanyEntity findByUserIdAndEmail(String userId, String email);
//    public CompanyEntity findByUserIdOrEmail(String userId, String email);

}

