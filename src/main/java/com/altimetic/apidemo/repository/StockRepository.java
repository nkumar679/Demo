package com.altimetic.apidemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.altimetic.apidemo.entity.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

	@Query("SELECT s FROM Stock s WHERE s.stock in :stockNames")
	List<Stock> findByStocks(List<String> stockNames);

	@Query("SELECT s FROM Stock s WHERE s.stock in :stockName")
	Stock findByStockName(String stockName);
	
	
}
