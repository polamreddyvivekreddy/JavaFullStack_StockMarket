package com.example.stockAppApiUser.ui;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.stockAppApiUser.dto.UserDto;
import com.example.stockAppApiUser.model.UserEntity;
import com.example.stockAppApiUser.service.UserService;
import com.example.stockAppApiUser.shared.UserRequestModelEntity;
import com.example.stockAppApiUser.shared.UserResponseModelEntity;

@RestController
@RequestMapping("/api")
public class UserRestController {
	private UserService userService;

	@Autowired
	public UserRestController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/users")
	public ResponseEntity<UserResponseModelEntity> createUser(@RequestBody UserRequestModelEntity userDetails) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserDto userDto = mapper.map(userDetails, UserDto.class);
		userService.createUser(userDto);
		UserResponseModelEntity userResponseModelEntity = mapper.map(userDto, UserResponseModelEntity.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(userResponseModelEntity);
	}

	@GetMapping("/users/{userId}")
	public ResponseEntity<UserResponseModelEntity> findUserByUserId(@PathVariable("userId") String userId)
			throws UserNotFoundException {
		UserEntity userEntity = userService.findByUserId(userId);
		if (userEntity == null) {
			throw new UserNotFoundException("user not found with the user id: " + userId);
		}
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return ResponseEntity.status(HttpStatus.FOUND).body(mapper.map(userEntity, UserResponseModelEntity.class));

	}
	
	@GetMapping("/users/{userId}/{email}")
	public ResponseEntity<UserResponseModelEntity> findUserByUserIdAndEmail(@PathVariable("userId") String userId, @PathVariable("email") String email)
			throws UserNotFoundException {
		//UserEntity userEntity = userService.findByUserIdAndEmail(userId, email);
		
		UserEntity userEntity = userService.findByUserIdOrEmail(userId, email);
		if (userEntity == null) {
			throw new UserNotFoundException("user not found with the user id and email: " + userId);
		}
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return ResponseEntity.status(HttpStatus.FOUND).body(mapper.map(userEntity, UserResponseModelEntity.class));

	}
}
