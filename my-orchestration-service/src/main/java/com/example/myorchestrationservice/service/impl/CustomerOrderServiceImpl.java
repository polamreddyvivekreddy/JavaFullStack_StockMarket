package com.example.myorchestrationservice.service.impl;
import com.example.myorchestrationservice.dto.CustomerDTO;
import com.example.myorchestrationservice.dto.CustomerOrderDTO;
import com.example.myorchestrationservice.dto.OrderDTO;
import com.example.myorchestrationservice.service.CustomerOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {


    private RestTemplate restTemplate;

    public CustomerOrderServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    //using SPEL(Spring Expression Language
    @Value("${orders.url}")
    private String orderServiceURL;
    //using SPEL(Spring Expression Language
    @Value("${customers.url}")
    private String customerServiceURL;

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerOrderServiceImpl.class);

    @Override
    public CustomerOrderDTO getCustomerOrder(Integer orderId) throws Exception {
        CustomerOrderDTO customerOrderDTO = new CustomerOrderDTO();

        LOGGER.info("Fetching Customer and Order details for OrderId: {}", orderId);

        OrderDTO order = getOrder(orderId);

        if (order != null) {
            customerOrderDTO.setOrder(order);
            customerOrderDTO.setCustomer(getCustomer(order.getCustomerId()));
        } else {
            LOGGER.error("No Order found for, OrderId: {}", orderId);
        }

        return customerOrderDTO;
    }

    private OrderDTO getOrder(Integer orderId) {
        ResponseEntity<OrderDTO> orderDTOResponse = restTemplate.getForEntity(orderServiceURL + orderId, OrderDTO.class);
        return orderDTOResponse.getBody();
    }

    private CustomerDTO getCustomer(Integer customerId) {
        ResponseEntity<CustomerDTO> customerDTOResponse = restTemplate.getForEntity(customerServiceURL + customerId, CustomerDTO.class);
        return customerDTOResponse.getBody();
    }
}
