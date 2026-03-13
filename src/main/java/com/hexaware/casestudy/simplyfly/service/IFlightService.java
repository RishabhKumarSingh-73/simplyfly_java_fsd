package com.hexaware.casestudy.simplyfly.service;

import java.util.List;

import com.hexaware.casestudy.simplyfly.dto.flight.FlightResponseDto;
import com.hexaware.casestudy.simplyfly.entity.Flight;
import com.hexaware.casestudy.simplyfly.exception.FlightNotFoundException;

public interface IFlightService {
	
	List<FlightResponseDto> getAllFlights();
	FlightResponseDto getFlightById(int id)throws FlightNotFoundException;
	FlightResponseDto getFlightByNumber(String flightNumber)throws FlightNotFoundException;
    List<FlightResponseDto> getFlightsByOwnerId(int ownerId);
    FlightResponseDto addFlight(Flight flight);
    FlightResponseDto updateFlight(Flight flight)throws FlightNotFoundException;
    String deleteFlightById(int id)throws FlightNotFoundException;
}
