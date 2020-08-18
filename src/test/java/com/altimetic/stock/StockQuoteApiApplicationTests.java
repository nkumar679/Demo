package com.altimetic.stock;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.altimetic.apidemo.controller.StockController;
import com.altimetic.apidemo.entity.Stock;
import com.altimetic.apidemo.repository.StockRepository;

@WebMvcTest(StockController.class)
class StockQuoteApiApplicationTests {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	StockRepository stockRepository;
	
	@Test
	void testGetStock() throws Exception {
		Stock stock1 = new Stock("HCL","HCL Tech",new Date(),new BigDecimal(200.20),"INR");
		Stock stock2 = new Stock("IBM","IBM Tech",new Date(),new BigDecimal(200.20),"INR");
		
		List<Stock> stocks = new ArrayList<Stock>();
		stocks.add(stock1);
		stocks.add(stock2);
		
		List<String> stockNames = new ArrayList<String>();
		stockNames.add("HCL");
		stockNames.add("IBM");
		
		Mockito.when(stockRepository.findByStocks(stockNames)).thenReturn(stocks);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/stockQuote?stockName=HCL,IBM");
		MvcResult mvcResult = mvc.perform(requestBuilder).andReturn();
		
		MockHttpServletResponse response = mvcResult.getResponse();
		assertEquals(HttpStatus.OK, response.getStatus());
	}

}
