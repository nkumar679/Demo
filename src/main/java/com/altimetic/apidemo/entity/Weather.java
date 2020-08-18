package com.altimetic.apidemo.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Weather {

	@Id
	private Long pincode;

	@Column(unique = true, nullable = false)
	private String city;
	
	@Column(nullable = false)
	private int minTemprature;
	
	@Column(nullable = false)
	private int maxTemprature;
	
	@Column(nullable = false)
	private int currentTemprature;
	
	public Weather() {
		// TODO Auto-generated constructor stub
	}
	
	public Weather(Long pincode, String city, int minTemprature, int maxTemprature, int currentTemprature) {
		super();
		this.pincode = pincode;
		this.city = city;
		this.minTemprature = minTemprature;
		this.maxTemprature = maxTemprature;
		this.currentTemprature = currentTemprature;
	}



	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getMinTemprature() {
		return minTemprature;
	}

	public void setMinTemprature(int minTemprature) {
		this.minTemprature = minTemprature;
	}

	public int getMaxTemprature() {
		return maxTemprature;
	}

	public void setMaxTemprature(int maxTemprature) {
		this.maxTemprature = maxTemprature;
	}

	public int getCurrentTemprature() {
		return currentTemprature;
	}

	public void setCurrentTemprature(int currentTemprature) {
		this.currentTemprature = currentTemprature;
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, currentTemprature, maxTemprature, minTemprature, pincode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Weather))
			return false;
		Weather other = (Weather) obj;
		return Objects.equals(city, other.city) && currentTemprature == other.currentTemprature
				&& maxTemprature == other.maxTemprature && minTemprature == other.minTemprature
				&& pincode == other.pincode;
	}

	@Override
	public String toString() {
		return "Weather [pincode=" + pincode + ", city=" + city + ", minTemprature=" + minTemprature
				+ ", maxTemprature=" + maxTemprature + ", currentTemprature=" + currentTemprature + "]";
	}
	
	
}
