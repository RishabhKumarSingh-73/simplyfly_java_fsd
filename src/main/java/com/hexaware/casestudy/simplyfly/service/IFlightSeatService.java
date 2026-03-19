package com.hexaware.casestudy.simplyfly.service;

import java.util.List;

import com.hexaware.casestudy.simplyfly.dto.flight_seat.FlightSeatResponseDto;
import com.hexaware.casestudy.simplyfly.enums.FlightSeatStatus;
import com.hexaware.casestudy.simplyfly.exception.FlightSeatNotFoundException;

public interface IFlightSeatService {
	
	List<FlightSeatResponseDto> getSeatsByScheduleId(int flightScheduleId);
    List<FlightSeatResponseDto> getAvailableSeatsByScheduleId(int flightScheduleId);
    FlightSeatResponseDto getFlightSeatById(int id)throws FlightSeatNotFoundException;
    FlightSeatResponseDto updateSeatStatus(int flightSeatId, FlightSeatStatus status)throws FlightSeatNotFoundException;
}
