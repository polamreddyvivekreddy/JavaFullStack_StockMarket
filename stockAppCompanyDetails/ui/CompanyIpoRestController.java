package com.example.stockAppCompanyDetails.ui;

import java.lang.reflect.Type;
import java.util.List;

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

import com.example.stockAppCompanyDetails.dto.CompanyDto;
import com.example.stockAppCompanyDetails.dto.CompanyIpoDto;
import com.example.stockAppCompanyDetails.model.CompanyEntity;
import com.example.stockAppCompanyDetails.model.CompanyIpoEntity;
import com.example.stockAppCompanyDetails.service.CompanyIpoService;
import com.example.stockAppCompanyDetails.shared.CompanyIpoRequestModelEntity;
import com.example.stockAppCompanyDetails.shared.CompanyIpoResponseModelEntity;

@RestController
@RequestMapping("/companyIpo")
public class CompanyIpoRestController {
	private CompanyIpoService companyIpoService;

	@Autowired
	public CompanyIpoRestController(CompanyIpoService companyIpoService) {
		this.companyIpoService = companyIpoService;
	}

	@PostMapping("/addCompanyIpo")
	public ResponseEntity<CompanyIpoResponseModelEntity> createCompanyIpo(@RequestBody CompanyIpoRequestModelEntity companyIpoDetails) {
		ModelMapper mapper = new ModelMapper();
		//mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		CompanyIpoDto companyIpoDto = mapper.map(companyIpoDetails, CompanyIpoDto.class);
//		System.out.println(companyIpoDto.getCompanyIpoName());
		companyIpoService.createCompanyIpo(companyIpoDto);
		CompanyIpoResponseModelEntity companyIpoResponseModelEntity = mapper.map(companyIpoDto, CompanyIpoResponseModelEntity.class);
//		System.out.println(companyIpoResponseModelEntity.getCompanyIpoName());
		return ResponseEntity.status(HttpStatus.CREATED).body(companyIpoResponseModelEntity);
	}

	@GetMapping("/ipoId/{companyIpoId}")
	public ResponseEntity<CompanyIpoResponseModelEntity> findCompanyIpoById(@PathVariable("companyIpoId") Integer companyIpoId)
			throws CompanyNotFoundException {
		CompanyIpoEntity companyIpoEntity = companyIpoService.findByCompanyIpoId(companyIpoId);
		if (companyIpoEntity == null) {
			throw new CompanyNotFoundException("company not found with the company id: " + companyIpoId);
		}
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return ResponseEntity.status(HttpStatus.FOUND).body(mapper.map(companyIpoEntity, CompanyIpoResponseModelEntity.class));

	}
	
	@GetMapping("/ipoName/{companyIpoName}")
	public ResponseEntity<CompanyIpoResponseModelEntity> findCompanyIpoByName(@PathVariable("companyIpoName") String companyIpoName)
			throws CompanyNotFoundException {
		CompanyIpoEntity companyIpoEntity = companyIpoService.findByCompanyIpoName(companyIpoName);
		if (companyIpoEntity == null) {
			throw new CompanyNotFoundException("company not found with the company id: " + companyIpoName);
		}
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return ResponseEntity.status(HttpStatus.FOUND).body(mapper.map(companyIpoEntity, CompanyIpoResponseModelEntity.class));

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
