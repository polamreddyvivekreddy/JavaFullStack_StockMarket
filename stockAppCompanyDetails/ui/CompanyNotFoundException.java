package com.example.stockAppCompanyDetails.ui;

public class CompanyNotFoundException extends Throwable {
    
	
	private String msg;

	public CompanyNotFoundException(String msg) {
		this.msg = msg;
	}

	public CompanyNotFoundException() {
	}

	public String getMsg() {
		return msg;
	}
	
	
	
	}
