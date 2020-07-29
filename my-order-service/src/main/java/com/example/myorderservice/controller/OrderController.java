package com.example.myorderservice.controller;
import com.example.myorderservice.dto.OrderDTO;
import com.example.myorderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

//    ,consumes = MediaType.APPLICATION_JSON_VALUE
    @RequestMapping(value = "/orders/{orderId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public OrderDTO getOrder(@PathVariable Integer orderId) throws Exception {
        return orderService.getOrder(orderId);
    }
}
