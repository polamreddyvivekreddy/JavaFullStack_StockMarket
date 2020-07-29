package com.example.myorderservice.service.impl;
import com.example.myorderservice.dao.OrderRepository;
import com.example.myorderservice.dao.entities.OrderEntity;
import com.example.myorderservice.dto.OrderDTO;
import com.example.myorderservice.dto.OrderMapper;
import com.example.myorderservice.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Override
    public OrderDTO getOrder(Integer orderId) throws Exception {
        LOGGER.info("Fetching Order details for OrderId: {}", orderId);
        Optional<OrderEntity> orderEntity = orderRepository.findById(orderId);
        OrderDTO orderDTO = null;

        if (orderEntity.isPresent()) {
            orderDTO = OrderMapper.INSTANCE.orderEntityToDTO(orderEntity.get());
        }

        return orderDTO;
    }
}
