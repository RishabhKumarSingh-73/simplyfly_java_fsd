package com.hexaware.casestudy.simplyfly.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.casestudy.simplyfly.entity.FlightSchedule;
import java.time.LocalDateTime;


public interface FlightScheduleRepository extends JpaRepository<FlightSchedule, Integer> {

	List<FlightSchedule> findByRoute_IdAndDepartureDateTime(int route_Id, LocalDateTime departureDateTime);
	List<FlightSchedule> findByFlight_Id(int flight_Id);
	
}
