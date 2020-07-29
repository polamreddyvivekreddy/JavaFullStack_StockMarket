package com.example.myorderservice.service;


import com.example.myorderservice.dto.OrderDTO;

public interface OrderService {

    OrderDTO getOrder(Integer orderId) throws Exception;
}
