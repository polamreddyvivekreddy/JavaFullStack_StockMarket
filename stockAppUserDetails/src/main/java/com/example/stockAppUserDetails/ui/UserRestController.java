package com.example.stockAppUserDetails.ui;

import java.util.List;

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

import com.example.stockAppUserDetails.dto.UserDto;
import com.example.stockAppUserDetails.model.UserEntity;
import com.example.stockAppUserDetails.service.UserService;
import com.example.stockAppUserDetails.shared.UserRequestModelEntity;
import com.example.stockAppUserDetails.shared.UserResponseModelEntity;



@RestController 
@RequestMapping("/user")
public class UserRestController {
	private UserService userService;

	@Autowired
	public UserRestController(UserService userService) {

		this.userService = userService;
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<UserResponseModelEntity> createUser(@RequestBody UserRequestModelEntity userDetails) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserDto userDto = mapper.map(userDetails, UserDto.class);
		userService.createUser(userDto);
		UserResponseModelEntity userResponseModelEntity = mapper.map(userDto, UserResponseModelEntity.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(userResponseModelEntity);
	}



	@GetMapping("/id/{userId}")
	public ResponseEntity<UserResponseModelEntity> findUserById(@PathVariable("userId") Integer userId)
			throws UserNotFoundException {
		UserEntity userEntity = userService.findByUserId(userId);
		if (userEntity == null) {
			throw new UserNotFoundException("user not found with the user id: " + userId);
		}
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return ResponseEntity.status(HttpStatus.FOUND).body(mapper.map(userEntity, UserResponseModelEntity.class));

	}
	
	@GetMapping("/name/{userName}")
	public ResponseEntity<UserResponseModelEntity> findUserByName(@PathVariable("userName") String userName)
			throws UserNotFoundException {
		UserEntity userEntity = userService.findByUserName(userName);
		if (userEntity == null) {
			throw new UserNotFoundException("user not found with the user name: " + userName);
		}
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return ResponseEntity.status(HttpStatus.FOUND).body(mapper.map(userEntity, UserResponseModelEntity.class));

	}
	
	@GetMapping("/{pattern}")
	public ResponseEntity<UserResponseModelEntity> findByUserNameContaining(@PathVariable("pattern") String pattern)
			throws UserNotFoundException {
		List<UserEntity> userEntity = userService.findByUserNameStartingWith(pattern);
		if (userEntity == null) {
			throw new UserNotFoundException("user not found with the user with words: " + pattern);
		}
		ModelMapper mapper = new ModelMapper();
//		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return ResponseEntity.status(HttpStatus.FOUND).body(mapper.map(userEntity, UserResponseModelEntity.class));

	}
	
	
	
	
	
//	@GetMapping("/users/{userId}/{email}")
//	public ResponseEntity<CompanyResponseModelEntity> findUserByUserIdAndEmail(@PathVariable("userId") String userId, @PathVariable("email") String email)
//			throws CompanyNotFoundException {
//		//CompanyEntity userEntity = userService.findByUserIdAndEmail(userId, email);
//		
//		CompanyEntity userEntity = userService.findByUserIdOrEmail(userId, email);
//		if (userEntity == null) {
//			throw new CompanyNotFoundException("user not found with the user id and email: " + userId);
//		}
//		ModelMapper mapper = new ModelMapper();
//		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
//		return ResponseEntity.status(HttpStatus.FOUND).body(mapper.map(userEntity, CompanyResponseModelEntity.class));
//
//	}
}
