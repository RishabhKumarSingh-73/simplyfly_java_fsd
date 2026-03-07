package com.hexaware.casestudy.simplyfly.service;

import java.util.List;

import com.hexaware.casestudy.simplyfly.entity.Flight;
import com.hexaware.casestudy.simplyfly.exception.FlightNotFoundException;

public interface IFlightService {
	
	List<Flight> getAllFlights();
    Flight getFlightById(int id)throws FlightNotFoundException;
    Flight getFlightByNumber(String flightNumber)throws FlightNotFoundException;
    List<Flight> getFlightsByOwnerId(int ownerId);
    Flight addFlight(Flight flight);
    Flight updateFlight(Flight flight)throws FlightNotFoundException;
    String deleteFlightById(int id)throws FlightNotFoundException;
}
