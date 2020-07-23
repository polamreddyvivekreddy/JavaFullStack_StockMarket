package com.example.demo.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//@NoArgsConstructor
//@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "stockMarket_table")
public class Stock {
	@Id
	@Column(name = "stock_id")
	private UUID id;
	@Column(name = "stock_url")
	private String stockUrl;
	public Stock() {
		super();
	}

	public Stock(UUID id, String stockUrl) {
		super();
		this.id = id;
		this.stockUrl = stockUrl;
	}

	public Stock(String stockUrl) {
		super();
		this.stockUrl = stockUrl;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getStockUrl() {
		return stockUrl;
	}

	public void setStockUrl(String stockUrl) {
		this.stockUrl = stockUrl;
	}


}
