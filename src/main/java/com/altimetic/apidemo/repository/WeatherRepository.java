package com.altimetic.apidemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.altimetic.apidemo.entity.Weather;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long> {

	Weather findByCity(String city);
	
}
