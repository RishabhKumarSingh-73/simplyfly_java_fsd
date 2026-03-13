package com.hexaware.casestudy.simplyfly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.casestudy.simplyfly.dto.flight.FlightResponseDto;
import com.hexaware.casestudy.simplyfly.entity.Flight;
import com.hexaware.casestudy.simplyfly.exception.FlightNotFoundException;
import com.hexaware.casestudy.simplyfly.mapper.FlightMapper;
import com.hexaware.casestudy.simplyfly.repository.FlightRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class FlightServiceImp implements IFlightService {
	
	@Autowired
	private FlightRepository repository;

	@Override
	public List<FlightResponseDto> getAllFlights() {
		
		return repository.findAll().stream().map(entity->{
			return FlightMapper.flightToFlightResponseDto(entity);
		}).toList();
		
	}

	@Override
	public FlightResponseDto getFlightById(int id) throws FlightNotFoundException{
		
		Flight flight = repository.findById(id).orElseThrow(()-> new FlightNotFoundException("Flight record not found"));

		return FlightMapper.flightToFlightResponseDto(flight);
	
	}

	@Override
	public FlightResponseDto getFlightByNumber(String flightNumber)throws FlightNotFoundException {

		Flight flight = repository.findByFlightNumber(flightNumber).orElseThrow(()-> new FlightNotFoundException("Flight record not found"));
		
		return FlightMapper.flightToFlightResponseDto(flight);
	
	}

	@Override
	public List<FlightResponseDto> getFlightsByOwnerId(int ownerId){
		
		return repository.findByOwner_Id(ownerId).stream().map(entity->{
			return FlightMapper.flightToFlightResponseDto(entity);
		}).toList();
		
	}

	@Override
	public FlightResponseDto addFlight(Flight flight) {
		
		return FlightMapper.flightToFlightResponseDto(repository.save(flight));
	
	}

	@Override
	public FlightResponseDto updateFlight(Flight flight) throws FlightNotFoundException{

		repository.findById(flight.getId()).orElseThrow(()-> new FlightNotFoundException("Flight record not found"));
		
		return FlightMapper.flightToFlightResponseDto(repository.save(flight));
	
	}

	@Override
	public String deleteFlightById(int id) throws FlightNotFoundException{

		Flight flight = repository.findById(id).orElseThrow(()-> new FlightNotFoundException("Flight record not found"));
		
		repository.delete(flight);
		
		return "record deleted successfully.";
		
	}

}
