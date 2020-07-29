package com.example.customerService.dto;

import javax.annotation.Generated;
import org.springframework.stereotype.Component;

import com.example.customerService.dao.entities.CustomerEntity;
//import com.example.customerService.dto.OrderDTO;
//import com.example.customerService.dto.OrderMapper;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-07-28T13:58:13+0530",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_252 (Private Build)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerDTO orderEntityToDTO(CustomerEntity customerEntity) {
        if ( customerEntity == null ) {
            return null;
        }

        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setCustomerId( customerEntity.getCustomerId() );
        customerDTO.setFirstName( customerEntity.getFirstName() );
        customerDTO.setLastName( customerEntity.getLastName() );
        customerDTO.setCity( customerEntity.getCity() );
        customerDTO.setCountry( customerEntity.getCountry() );
        

        return customerDTO;
    }
}

