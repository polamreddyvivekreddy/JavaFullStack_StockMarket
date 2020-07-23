package com.example.stockAppApiUser.ui;

import com.example.stockAppApiUser.dto.UserDto;
import com.example.stockAppApiUser.service.UserService;
import com.example.stockAppApiUser.shared.UserRequestModelEntity;
import com.example.stockAppApiUser.shared.UserResponseModelEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserRestController {
    private UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/users")
    public ResponseEntity<UserResponseModelEntity> createUser(@RequestBody UserRequestModelEntity userDetails)
    {
        ModelMapper mapper=new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserDto userDto=mapper.map(userDetails,UserDto.class);
        userService.createUser(userDto);
        UserResponseModelEntity userResponseModelEntity=mapper.map(userDto,UserResponseModelEntity.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseModelEntity);
    }
}
