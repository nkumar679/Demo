package com.altimetic.stock;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.altimetic.stock.entity.Stock;
import com.altimetic.stock.repository.StockRepository;

@SpringBootApplication
public class StockQuoteApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockQuoteApiApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(StockRepository stockRespository) {
		return args -> {
			stockRespository.save(new Stock("HCL","HCL Tech",new Date(),new BigDecimal(200.20),"INR"));
			stockRespository.save(new Stock("HDFC","HDFC Bank",new Date(),new BigDecimal(200.20),"INR"));
			stockRespository.save(new Stock("RIL","Relaince Industries",new Date(),new BigDecimal(200.20),"INR"));
			stockRespository.save(new Stock("ICICI","ICICI Ltd",new Date(),new BigDecimal(200.20),"INR"));
			stockRespository.save(new Stock("TANSOL","Tansol Ltd",new Date(),new BigDecimal(200.20),"INR"));
			stockRespository.save(new Stock("HUL","Hindustan United Ltd",new Date(),new BigDecimal(200.20),"INR"));
			stockRespository.save(new Stock("INFOSYS","Infosys Pvt Ltd",new Date(),new BigDecimal(200.20),"INR"));
			stockRespository.save(new Stock("WIPRO","Wipro Pvt Ltd",new Date(),new BigDecimal(200.20),"INR"));
			stockRespository.save(new Stock("IBM","IBM",new Date(),new BigDecimal(200.20),"INR"));
			stockRespository.save(new Stock("GOOGLE","Google",new Date(),new BigDecimal(200.20),"INR"));
			
		};		
	}
}
