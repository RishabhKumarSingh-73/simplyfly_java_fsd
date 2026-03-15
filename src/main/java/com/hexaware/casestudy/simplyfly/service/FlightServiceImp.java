package com.hexaware.casestudy.simplyfly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.casestudy.simplyfly.dto.flight.FlightAddingRequestDto;
import com.hexaware.casestudy.simplyfly.dto.flight.FlightResponseDto;
import com.hexaware.casestudy.simplyfly.entity.AircraftModel;
import com.hexaware.casestudy.simplyfly.entity.Flight;
import com.hexaware.casestudy.simplyfly.entity.User;
import com.hexaware.casestudy.simplyfly.exception.AircraftModelNotFoundException;
import com.hexaware.casestudy.simplyfly.exception.FlightNotFoundException;
import com.hexaware.casestudy.simplyfly.exception.ServiceNotAllowedException;
import com.hexaware.casestudy.simplyfly.exception.UserNotFoundException;
import com.hexaware.casestudy.simplyfly.mapper.FlightMapper;
import com.hexaware.casestudy.simplyfly.repository.AircraftModelRepository;
import com.hexaware.casestudy.simplyfly.repository.FlightRepository;
import com.hexaware.casestudy.simplyfly.repository.FlightScheduleRepository;
import com.hexaware.casestudy.simplyfly.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class FlightServiceImp implements IFlightService {
	
	@Autowired
	private FlightRepository repository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AircraftModelRepository aircraftModelRepository;

	@Autowired
	private FlightScheduleRepository flightScheduleRepository;


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
	public FlightResponseDto addFlight(FlightAddingRequestDto flightDto)throws UserNotFoundException,AircraftModelNotFoundException {

		User user = userRepository.findById(flightDto.getOwnerId()).orElseThrow(()->new UserNotFoundException("user not found "));
		AircraftModel aircraftModel = aircraftModelRepository.findById(flightDto.getAircraftModelId()).orElseThrow(()->new AircraftModelNotFoundException("aircraft model not found"));
		

		Flight flight = FlightMapper.flightAddingRequestDtoToFlight(flightDto,user,aircraftModel);
		
		return FlightMapper.flightToFlightResponseDto(repository.save(flight));
	
	}

	@Override
	public FlightResponseDto deactivateFlight(int id) throws FlightNotFoundException{

		Flight flight = repository.findById(id).orElseThrow(()-> new FlightNotFoundException("Flight record not found"));

		flight.setActive(false);
		
		return FlightMapper.flightToFlightResponseDto(repository.save(flight));
	
	}

	@Override
	public FlightResponseDto activateFlight(int id) throws FlightNotFoundException{

		Flight flight = repository.findById(id).orElseThrow(()-> new FlightNotFoundException("Flight record not found"));

		flight.setActive(true);
		
		return FlightMapper.flightToFlightResponseDto(repository.save(flight));
	
	}

	@Override
	public String deleteFlightById(int id) throws FlightNotFoundException,ServiceNotAllowedException{

		Flight flight = repository.findById(id).orElseThrow(()-> new FlightNotFoundException("Flight record not found"));

		if(flightScheduleRepository.findByFlight_Id(id) == null)throw new ServiceNotAllowedException("Cant delete flight with existing schedules");
		
		repository.delete(flight);
		
		return "record deleted successfully.";
		
	}

}
