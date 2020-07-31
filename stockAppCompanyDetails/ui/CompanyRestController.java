package com.example.stockAppCompanyDetails.ui;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
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

import com.example.stockAppCompanyDetails.dao.CompanyRepository;
import com.example.stockAppCompanyDetails.dto.CompanyDto;
import com.example.stockAppCompanyDetails.exception.CompanyNotFoundException;
import com.example.stockAppCompanyDetails.model.CompanyEntity;
import com.example.stockAppCompanyDetails.service.CompanyService;
import com.example.stockAppCompanyDetails.shared.CompanyRequestModelEntity;
import com.example.stockAppCompanyDetails.shared.CompanyResponseModelEntity;

@RestController 
@RequestMapping("/company")
public class CompanyRestController {
	private CompanyService companyService;

	@Autowired
	public CompanyRestController(CompanyService companyService) {
		this.companyService = companyService;
	}

	@PostMapping("/addCompany")
	public ResponseEntity<CompanyResponseModelEntity> createCompany(@RequestBody CompanyRequestModelEntity companyDetails) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		CompanyDto companyDto = mapper.map(companyDetails, CompanyDto.class);
		companyService.createCompany(companyDto);
		CompanyResponseModelEntity companyResponseModelEntity = mapper.map(companyDto, CompanyResponseModelEntity.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(companyResponseModelEntity);
	}
	
	@GetMapping("/all")
	public List<CompanyDto> findAll()
			throws CompanyNotFoundException {
		List<CompanyEntity> companyEntity = companyService.findAll();
		ModelMapper mapper = new ModelMapper();
		Type listType = new TypeToken<List<CompanyDto>>(){}.getType();
        List<CompanyDto> postDtoList = mapper.map(companyEntity,listType);
        return postDtoList;
	}
	

	@GetMapping("/id/{companyId}")
	public ResponseEntity<CompanyResponseModelEntity> findCompanyById(@PathVariable("companyId") Integer companyId)
			throws CompanyNotFoundException, CompanyNotFoundException {
		Optional<CompanyEntity> companyEntity = companyService.findByCompanyId(companyId);
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return ResponseEntity.status(HttpStatus.FOUND).body(mapper.map(companyEntity, CompanyResponseModelEntity.class));

	}
	
	@GetMapping("/name/{companyName}")
	public ResponseEntity<CompanyResponseModelEntity> findCompanyByName(@PathVariable("companyName") String companyName)
			throws CompanyNotFoundException {
		CompanyEntity companyEntity = companyService.findByCompanyName(companyName);
		if (companyEntity == null) {
			throw new CompanyNotFoundException("company not found with the company id: " + companyName);
		}
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return ResponseEntity.status(HttpStatus.FOUND).body(mapper.map(companyEntity, CompanyResponseModelEntity.class));

	}
	
	@GetMapping("/{pattern}")
	public List<CompanyDto> findByCompanyNameContaining(@PathVariable("pattern") String pattern)
			throws CompanyNotFoundException {
		List<CompanyEntity> companyEntity = companyService.findByCompanyNameContaining(pattern);
		ModelMapper mapper = new ModelMapper();
		Type listType = new TypeToken<List<CompanyDto>>(){}.getType();
        List<CompanyDto> postDtoList = mapper.map(companyEntity,listType);
        return postDtoList;
	}
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

