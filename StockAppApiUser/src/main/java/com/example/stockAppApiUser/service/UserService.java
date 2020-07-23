package com.example.stockAppApiUser.service;
import com.example.stockAppApiUser.dto.UserDto;
import com.example.stockAppApiUser.shared.UserRequestModelEntity;
import com.example.stockAppApiUser.shared.UserResponseModelEntity;
public interface UserService {

    public UserResponseModelEntity createUser(UserDto userDto);
}
