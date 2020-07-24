package com.example.stockAppApiUser.dao;

import com.example.stockAppApiUser.model.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity,Integer> {
    public UserEntity findByUserId(String userId);
    public UserEntity findByEmail(String email);
    
    public UserEntity findByUserIdAndEmail(String userId, String email);
    public UserEntity findByUserIdOrEmail(String userId, String email);

}
