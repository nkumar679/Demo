package com.altimetic.stock.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.altimetic.stock.entity.Stock;
import com.altimetic.stock.repository.StockRepository;

@RestController
@Validated 
public class StockController {

	@Autowired
	private StockRepository stockRepository;
	
	@RequestMapping(method = RequestMethod.GET, value = "/stockQuote", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> findStock(@RequestParam(value="stockName", required=true) String param1){
		List<String> stockList = Arrays.asList(param1.split(",")); 
		if (stockList.size()>10) {
			return ResponseEntity.badRequest().body("Stock list size should not be more than 10");
		}
		for (String stock : stockList) {
			if (stockRepository.findByStockName(stock)==null) {
				return ResponseEntity.badRequest().body("non-available stock quote "+stock);
			}
		}
		return ResponseEntity.ok().body(stockRepository.findByStocks(stockList));
		
	}
	
	@RequestMapping(method = RequestMethod.POST,value = "/save/stock")
	public Stock saveStock(@Valid @RequestBody Stock stock) {
		return stockRepository.save(stock);
	}
}
