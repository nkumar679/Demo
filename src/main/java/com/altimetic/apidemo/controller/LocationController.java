package com.altimetic.apidemo.controller;

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

import com.altimetic.apidemo.entity.Location;
import com.altimetic.apidemo.repository.LocationRepository;

@RestController
@Validated
public class LocationController {

	@Autowired
	private LocationRepository locationRepository;
	
	@RequestMapping(value = "/location", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Location> getLocation(@RequestParam @Valid @Min(value = 100000) @Max(value = 999999) int pincode){
		return ResponseEntity.ok().body(locationRepository.findByPincode(pincode));		
	}
}
