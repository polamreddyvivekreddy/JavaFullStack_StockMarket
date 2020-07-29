package com.example.myorchestrationservice.service;

import com.example.myorchestrationservice.dto.CustomerOrderDTO;

public interface CustomerOrderService {


    CustomerOrderDTO getCustomerOrder(Integer orderId) throws Exception;
}
