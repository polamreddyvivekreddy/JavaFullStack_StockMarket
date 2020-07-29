package com.example.myorderservice.dto;
import com.example.myorderservice.dao.entities.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring")
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
    OrderDTO orderEntityToDTO(OrderEntity orderEntity);
}
