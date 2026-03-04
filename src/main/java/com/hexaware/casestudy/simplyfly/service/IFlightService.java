package com.hexaware.casestudy.simplyfly.service;

import java.util.List;

import com.hexaware.casestudy.simplyfly.entity.Flight;

public interface IFlightService {
	
	List<Flight> getAllFlights();
    Flight getFlightById(int id);
    Flight getFlightByNumber(String flightNumber);
    List<Flight> getFlightsByOwnerId(int ownerId);
    int addFlight(Flight flight);
    int updateFlight(Flight flight);
    int deleteFlightById(int id);
}
