package com.example.customerService.dto;

import javax.persistence.Column;
import javax.persistence.Id;

import lombok.Data;

/**
 * POJO for holding Order related data
 */
@Data
public class CustomerDTO {


	    private Integer customerId;

	    private String firstName;

	    private String lastName;

	    private String city;


	    private String country;


		public void setStatus(Object status) {
			// TODO Auto-generated method stub
			
		}


		public void setTotalAmount(Object totalAmount) {
			// TODO Auto-generated method stub
			
		}
}
