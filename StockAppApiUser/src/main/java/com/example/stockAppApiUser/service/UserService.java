package com.example.stockAppApiUser.service;
import com.example.stockAppApiUser.dto.UserDto;
import com.example.stockAppApiUser.model.UserEntity;
import com.example.stockAppApiUser.shared.UserResponseModelEntity;
public interface UserService {

    public UserResponseModelEntity createUser(UserDto userDto);
    public UserEntity findByUserId(String userId);
    public UserEntity findByEmail(String email);
    public UserEntity findByUserIdAndEmail(String userId, String email);
    public UserEntity findByUserIdOrEmail(String userId, String email);
}
