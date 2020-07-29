package com.example.customerService.service.impl;
import com.example.customerService.dao.CustomerRepository;
//import com.example.customerService.dao.OrderRepository;
import com.example.customerService.dao.entities.CustomerEntity;
import com.example.customerService.dto.CustomerDTO;
import com.example.customerService.dto.CustomerMapper;
//import com.example.customerService.dto.OrderDTO;
//import com.example.customerService.dto.OrderMapper;
import com.example.customerService.service.CustomerService;
//import com.example.customerService.service.OrderService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Override
    public CustomerDTO getOrder(Integer customerId) throws Exception {
        LOGGER.info("Fetching Order details for CustomerId: {}", customerId);
        Optional<CustomerEntity> customerEntity = customerRepository.findById(customerId);
        CustomerDTO customerDTO = null;

        if (customerEntity.isPresent()) {
            customerDTO = CustomerMapper.INSTANCE.orderEntityToDTO(customerEntity.get());
        }

        return customerDTO;
    }
}
