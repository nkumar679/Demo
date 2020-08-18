package com.altimetic.apidemo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.altimetic.apidemo.entity.Location;
import com.altimetic.apidemo.entity.Stock;
import com.altimetic.apidemo.entity.Weather;
import com.altimetic.apidemo.repository.LocationRepository;
import com.altimetic.apidemo.repository.StockRepository;
import com.altimetic.apidemo.repository.WeatherRepository;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(StockRepository stockRespository,
			LocationRepository locationRepository,
			WeatherRepository weatherRepository) {
		return args -> {
			
			//For Stock Demo
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
			
			
			//For Location API Demo
			locationRepository.save(new Location(411047, "Pune", "Vishrantwadi"));
			locationRepository.save(new Location(411057, "Pune", "Hinzewadi"));
			locationRepository.save(new Location(411038, "Pune", "Shivajinagar"));
			locationRepository.save(new Location(411001, "Pune", "Pune City"));
			locationRepository.save(new Location(411014, "Pune", "Vimannagar"));
			locationRepository.save(new Location(411088, "Pune", "Hadpasar"));
			
			//For Weather API
			weatherRepository.save(new Weather(411057L, "Pune", 12, 34, 24));
		};		
	}
}
