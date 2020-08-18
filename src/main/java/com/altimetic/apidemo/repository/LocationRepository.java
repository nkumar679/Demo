package com.altimetic.apidemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.altimetic.apidemo.entity.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

	@Query("SELECT l FROM Location l WHERE l.pincode = :pincode")
	Location findByPincode(int pincode);
}
