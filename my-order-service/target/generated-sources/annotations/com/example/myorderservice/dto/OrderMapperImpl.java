package com.example.myorderservice.dto;

import com.example.myorderservice.dao.entities.OrderEntity;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-07-28T13:58:13+0530",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_252 (Private Build)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderDTO orderEntityToDTO(OrderEntity orderEntity) {
        if ( orderEntity == null ) {
            return null;
        }

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setOrderId( orderEntity.getOrderId() );
        orderDTO.setCustomerId( orderEntity.getCustomerId() );
        orderDTO.setStatus( orderEntity.getStatus() );
        orderDTO.setTotalAmount( orderEntity.getTotalAmount() );

        return orderDTO;
    }
}
