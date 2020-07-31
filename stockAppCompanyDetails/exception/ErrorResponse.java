package com.example.stockAppCompanyDetails.exception;




public class ErrorResponse {
    private String errorMessage;
    private int statusCode;
    private Long timeHappened;
    
    
	public ErrorResponse() {
	}


	public ErrorResponse(String errorMessage, int statusCode, Long timeHappened) {
		this.errorMessage = errorMessage;
		this.statusCode = statusCode;
		this.timeHappened = timeHappened;
	}


	public String getErrorMessage() {
		return errorMessage;
	}


	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}


	public int getStatusCode() {
		return statusCode;
	}


	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}


	public Long getTimeHappened() {
		return timeHappened;
	}


	public void setTimeHappened(Long timeHappened) {
		this.timeHappened = timeHappened;
	}
    
	
    
}
