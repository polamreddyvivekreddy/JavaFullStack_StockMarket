package com.example.myorchestrationservice.controller;
import com.example.myorchestrationservice.dto.CustomerOrderDTO;
import com.example.myorchestrationservice.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerOrderController {

    private CustomerOrderService customerOrderService;

    public CustomerOrderController(CustomerOrderService customerOrderService) {
        this.customerOrderService = customerOrderService;
    }

    @RequestMapping(value = "/customer-orders/{orderId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerOrderDTO getCustomerOrder(@PathVariable Integer orderId) throws Exception {
        return customerOrderService.getCustomerOrder(orderId);
    }
}
