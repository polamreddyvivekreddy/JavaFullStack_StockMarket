package com.example.demo.dao;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Stock;

@Repository
public interface StockDao extends CrudRepository<Stock, UUID>{

}
