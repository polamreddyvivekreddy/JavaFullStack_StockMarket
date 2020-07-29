package com.example.customerService.controller;
//import com.example.customerService.dto.OrderDTO;
//import com.example.customerService.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.customerService.dto.CustomerDTO;
import com.example.customerService.service.CustomerService;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

//    ,consumes = MediaType.APPLICATION_JSON_VALUE
    @RequestMapping(value = "/customer/{customerId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerDTO getOrder(@PathVariable Integer customerId) throws Exception {
        return customerService.getOrder(customerId);
    }
}




