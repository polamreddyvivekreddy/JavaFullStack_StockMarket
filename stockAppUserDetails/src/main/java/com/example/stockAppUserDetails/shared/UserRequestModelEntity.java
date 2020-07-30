package com.example.stockAppUserDetails.shared;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestModelEntity {
	 private Integer userId;
	    private String userName;
	    private String userPassword;
	    private String userType;
	    private String userEmail;
	    private String userMobileNumber;
}
