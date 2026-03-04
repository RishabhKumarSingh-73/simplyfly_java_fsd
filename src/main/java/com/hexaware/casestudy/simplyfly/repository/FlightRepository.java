package com.hexaware.casestudy.simplyfly.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.casestudy.simplyfly.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

}
