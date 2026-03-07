package com.hexaware.casestudy.simplyfly.service;

import java.util.List;

import com.hexaware.casestudy.simplyfly.entity.FlightSeat;
import com.hexaware.casestudy.simplyfly.enums.FlightSeatStatus;
import com.hexaware.casestudy.simplyfly.exception.FlightSeatNotFoundException;

public interface IFlightSeatService {
	
	List<FlightSeat> getSeatsByScheduleId(int flightScheduleId);
    List<FlightSeat> getAvailableSeatsByScheduleId(int flightScheduleId);
    FlightSeat getFlightSeatById(int id)throws FlightSeatNotFoundException;
    FlightSeat updateSeatStatus(int flightSeatId, FlightSeatStatus status)throws FlightSeatNotFoundException;
}
