package com.example.stockAppCompanyDetails.exception;

import lombok.Getter;

@Getter
public class CompanyNotFoundException extends Throwable {
    private String message;
    public CompanyNotFoundException() {
    }
    public CompanyNotFoundException(String s) {
        this.message=s;
    }
	public void setMessage(String message) {
		this.message = message;
	}
    

}
	