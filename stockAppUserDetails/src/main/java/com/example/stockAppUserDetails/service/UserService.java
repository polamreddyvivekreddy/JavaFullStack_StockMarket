package com.example.stockAppUserDetails.service;
import java.util.List;

import com.example.stockAppUserDetails.dto.UserDto;
import com.example.stockAppUserDetails.model.UserEntity;
import com.example.stockAppUserDetails.shared.UserResponseModelEntity;
public interface UserService {

    public UserResponseModelEntity createUser(UserDto userDto);
    public UserEntity findByUserId(Integer userId);
    public UserEntity findByUserName(String userName);
    public List<UserEntity> findByUserNameStartingWith(String pattern);
//    public CompanyEntity findByUserIdAndEmail(String userId, String email);
//    public CompanyEntity findByUserIdOrEmail(String userId, String email);
}
