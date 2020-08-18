package com.altimetic.apidemo.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
public class Location {

	@Id
	@GeneratedValue
	private long locationId;

	@Column(unique = true, nullable = false)
	@Min(value = 100000, message = "Minimum Length Should Be 6 Digit")
	@Max(value = 999999, message = "Maximum Length Should Be 6 Digit")
	private int pincode;
	
	public Location() {
		// TODO Auto-generated constructor stub
	}
	
	public Location(
			@Min(value = 100000, message = "Minimum Length Should Be 6 Digit") @Max(value = 999999, message = "Maximum Length Should Be 6 Digit") int pincode,
			@NotEmpty String locationname, @NotEmpty String area) {
		super();
		this.pincode = pincode;
		this.locationname = locationname;
		this.area = area;
	}

	@Column(nullable = false)
	@NotEmpty
	private String locationname;
	
	@Column(nullable = false)
	@NotEmpty
	private String area;

	public long getLocationId() {
		return locationId;
	}

	public void setLocationId(long locationId) {
		this.locationId = locationId;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getLocationname() {
		return locationname;
	}

	public void setLocationname(String locationname) {
		this.locationname = locationname;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Override
	public int hashCode() {
		return Objects.hash(area, locationId, locationname, pincode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Location))
			return false;
		Location other = (Location) obj;
		return Objects.equals(area, other.area) && locationId == other.locationId
				&& Objects.equals(locationname, other.locationname) && pincode == other.pincode;
	}

	@Override
	public String toString() {
		return "Location [locationId=" + locationId + ", pincode=" + pincode + ", locationname=" + locationname
				+ ", area=" + area + "]";
	}
	
	
}
