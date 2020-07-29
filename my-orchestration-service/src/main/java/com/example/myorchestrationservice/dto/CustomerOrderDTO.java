package com.example.myorchestrationservice.dto;
import lombok.Data;

@Data
public class CustomerOrderDTO {

    private CustomerDTO customer;

    private OrderDTO order;
}
