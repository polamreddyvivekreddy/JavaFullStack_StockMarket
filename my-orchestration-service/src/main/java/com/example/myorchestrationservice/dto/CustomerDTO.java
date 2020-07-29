package com.example.myorchestrationservice.dto;

import lombok.Data;
@Data
public class CustomerDTO {

    private Integer customerId;

    private String firstName;

    private String lastName;

    private String city;

    private String country;
}
