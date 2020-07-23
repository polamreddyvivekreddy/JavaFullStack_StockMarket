package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Stock;
import com.example.demo.service.StockService;

@RestController
@RequestMapping("/api/v1")
public class StockController {
	
	private StockService stockService;

	@Autowired
	public StockController(StockService stockService) {
		super();
		this.stockService = stockService;
	}
	
	@GetMapping("/stocks")
	public ResponseEntity<Iterable<Stock>> getAllStock()
	{
		
		return ResponseEntity.status(HttpStatus.OK).body(stockService.getAllStock());
	}

}
