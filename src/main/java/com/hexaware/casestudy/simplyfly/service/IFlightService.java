package com.hexaware.casestudy.simplyfly.service;

import java.util.List;

import com.hexaware.casestudy.simplyfly.dto.flight.FlightAddingRequestDto;
import com.hexaware.casestudy.simplyfly.dto.flight.FlightResponseDto;
import com.hexaware.casestudy.simplyfly.exception.AircraftModelNotFoundException;
import com.hexaware.casestudy.simplyfly.exception.FlightNotFoundException;
import com.hexaware.casestudy.simplyfly.exception.ServiceNotAllowedException;
import com.hexaware.casestudy.simplyfly.exception.UserNotFoundException;

public interface IFlightService {
	
	List<FlightResponseDto> getAllFlights();
	FlightResponseDto getFlightById(int id)throws FlightNotFoundException;
	FlightResponseDto getFlightByNumber(String flightNumber)throws FlightNotFoundException;
    List<FlightResponseDto> getFlightsByOwnerId(int ownerId);
    FlightResponseDto addFlight(FlightAddingRequestDto flightDto)throws UserNotFoundException,AircraftModelNotFoundException;
    FlightResponseDto deactivateFlight(int id)throws FlightNotFoundException;
    FlightResponseDto activateFlight(int id)throws FlightNotFoundException;
    String deleteFlightById(int id)throws FlightNotFoundException,ServiceNotAllowedException;
}
