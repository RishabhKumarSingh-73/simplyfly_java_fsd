package com.hexaware.casestudy.simplyfly.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.casestudy.simplyfly.entity.FlightSchedulePrice;
import java.util.List;
import java.util.Optional;

import com.hexaware.casestudy.simplyfly.enums.SeatClass;


public interface FlightSchedulePriceRepository extends JpaRepository<FlightSchedulePrice, Integer> {

	Optional<FlightSchedulePrice> findByFlightSchedule_IdAndSeatClass(int flightSchedule_Id, SeatClass seatClass);
	List<FlightSchedulePrice> findByFlightSchedule_Id(int flightSchedule_Id);
	
}
