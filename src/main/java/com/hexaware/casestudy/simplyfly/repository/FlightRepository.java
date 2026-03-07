package com.hexaware.casestudy.simplyfly.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.casestudy.simplyfly.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

	Optional<Flight> findByFlightNumber(String flightNumber);
	
	List<Flight> findByOwner_Id(int owner_Id);
	
}
