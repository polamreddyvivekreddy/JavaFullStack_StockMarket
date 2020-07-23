package com.example.demo.service;

import java.util.Optional;

//import com.example.demo.model.Image;
import com.example.demo.model.Stock;

public interface StockService {
	public Iterable<Stock> getAllStock();
	public Optional<Stock> createStock(Stock stock);

}
