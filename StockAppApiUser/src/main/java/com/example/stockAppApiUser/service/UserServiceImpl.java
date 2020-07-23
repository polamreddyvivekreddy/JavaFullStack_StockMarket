package com.example.stockAppApiUser.service;

import com.example.stockAppApiUser.dao.UserRepository;
import com.example.stockAppApiUser.dto.UserDto;
import com.example.stockAppApiUser.model.UserEntity;
import com.example.stockAppApiUser.shared.UserRequestModelEntity;
import com.example.stockAppApiUser.shared.UserResponseModelEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

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
        userDto.setUserId(UUID.randomUUID().toString());
        ModelMapper mapper=new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserEntity userEntity=mapper.map(userDto,UserEntity.class);
        userRepository.save(userEntity);
        return mapper.map(userEntity,UserResponseModelEntity.class);
    }
}
