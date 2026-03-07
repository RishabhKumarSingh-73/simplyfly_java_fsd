package com.hexaware.casestudy.simplyfly.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.casestudy.simplyfly.entity.Route;
import java.util.Optional;


public interface RouteRepository extends JpaRepository<Route, Integer> {

	Optional<Route> findBySourceAirportCodeAndDestinationAirportCode(String sourceAirportCode, String destinationAirportCode);
	
}
