package com.altimetic.apidemo.controller;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.altimetic.apidemo.entity.Weather;
import com.altimetic.apidemo.repository.WeatherRepository;

@RestController
@Validated
public class WeatherController {

	@Autowired
	private WeatherRepository weatherRepository;
	
	@RequestMapping(value = "/weather", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Weather> getWeatherBasedOnPincode(
			@RequestParam(required = false) @Valid @Min(value = 100000) @Max(value = 999999) Long pincode,
			@RequestParam(required = false) @Valid String city){
		if (city != null) {
			return ResponseEntity.ok().body(weatherRepository.findByCity(city));
		}
		else {
			return ResponseEntity.ok().body(weatherRepository.findById(pincode)
					.orElseThrow(() -> new EntityNotFoundException(String.valueOf(pincode))));
		}
				
	}
	
}
