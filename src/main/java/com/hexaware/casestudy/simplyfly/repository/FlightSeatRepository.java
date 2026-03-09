package com.hexaware.casestudy.simplyfly.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.casestudy.simplyfly.entity.FlightSeat;
import com.hexaware.casestudy.simplyfly.enums.FlightSeatStatus;

public interface FlightSeatRepository extends JpaRepository<FlightSeat, Integer> {

	List<FlightSeat> findByFlightSchedule_Id(int flightSchedule_Id);
	
	List<FlightSeat> findByFlightSchedule_IdAndStatus(int flightSchedule_Id,FlightSeatStatus status);
}
