package com.hexaware.casestudy.simplyfly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.casestudy.simplyfly.entity.Flight;
import com.hexaware.casestudy.simplyfly.exception.FlightNotFoundException;
import com.hexaware.casestudy.simplyfly.repository.FlightRepository;

@Service
public class FlightServiceImp implements IFlightService {
	
	@Autowired
	private FlightRepository repository;

	@Override
	public List<Flight> getAllFlights() {
		
		return repository.findAll();
		
	}

	@Override
	public Flight getFlightById(int id) throws FlightNotFoundException{

		return repository.findById(id).orElseThrow(()-> new FlightNotFoundException("Flight record not found"));
	
	}

	@Override
	public Flight getFlightByNumber(String flightNumber)throws FlightNotFoundException {

		return repository.findByFlightNumber(flightNumber).orElseThrow(()-> new FlightNotFoundException("Flight record not found"));
	
	}

	@Override
	public List<Flight> getFlightsByOwnerId(int ownerId){
		
		return repository.findByOwner_Id(ownerId);
		
	}

	@Override
	public Flight addFlight(Flight flight) {
		
		return repository.save(flight);
	
	}

	@Override
	public Flight updateFlight(Flight flight) throws FlightNotFoundException{

		repository.findById(flight.getId()).orElseThrow(()-> new FlightNotFoundException("Flight record not found"));
		
		return repository.save(flight);
	
	}

	@Override
	public String deleteFlightById(int id) throws FlightNotFoundException{

		Flight flight = repository.findById(id).orElseThrow(()-> new FlightNotFoundException("Flight record not found"));
		
		repository.delete(flight);
		
		return "record deleted successfully.";
		
	}

}
