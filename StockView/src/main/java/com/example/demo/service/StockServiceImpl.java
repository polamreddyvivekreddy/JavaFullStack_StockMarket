package com.example.demo.service;

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

}
