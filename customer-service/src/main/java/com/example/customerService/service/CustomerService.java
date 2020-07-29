package com.example.customerService.service;


import com.example.customerService.dto.CustomerDTO;
//import com.example.customerService.dto.OrderDTO;

public interface CustomerService {

    CustomerDTO getOrder(Integer orderId) throws Exception;
}
