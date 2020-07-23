package com.example.demo.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.demo.dao.StockDao;
import com.example.demo.model.Stock;
@Service
@EnableTransactionManagement
public class StockServiceImpl implements StockService{
	private StockDao stockDao;

	@Autowired
	public StockServiceImpl(StockDao stockDao) {
		super();
		this.stockDao = stockDao;
	}

	@Override
	@Transactional
	public Iterable<Stock> getAllStock() {
		// TODO Auto-generated method stub
		return stockDao.findAll();
	}

	@Override
	@Transactional
	public Optional<Stock> createStock(Stock stock) {
	
		stockDao.save(stock);
		return Optional.of(stock);
	}


}
