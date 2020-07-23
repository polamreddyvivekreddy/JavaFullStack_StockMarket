package com.example.demo;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dao.StockDao;
import com.example.demo.model.Stock;

@SpringBootApplication
public class StockServiceApplication implements CommandLineRunner{
	private StockDao stockDao;

	@Autowired
	public StockServiceApplication(StockDao stockDao) {
		super();
		this.stockDao = stockDao;
	}

	public static void main(String[] args) {
		SpringApplication.run(StockServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		stockDao.save(new Stock(UUID.randomUUID(), "demourl-1") );
		stockDao.save(new Stock(UUID.randomUUID(),"demourl-2"));
	}

}
