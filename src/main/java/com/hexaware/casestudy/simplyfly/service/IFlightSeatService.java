package com.hexaware.casestudy.simplyfly.service;

import java.util.List;

import com.hexaware.casestudy.simplyfly.entity.FlightSeat;

public interface IFlightSeatService {
	
	List<FlightSeat> getSeatsByScheduleId(int flightScheduleId);
    List<FlightSeat> getAvailableSeatsByScheduleId(int flightScheduleId);
    FlightSeat getFlightSeatById(int id);
    int updateSeatStatus(int flightSeatId, String status);
}
