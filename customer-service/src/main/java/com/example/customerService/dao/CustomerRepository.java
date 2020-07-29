package com.example.customerService.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.customerService.dao.entities.CustomerEntity;
@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity, Integer> {

}
