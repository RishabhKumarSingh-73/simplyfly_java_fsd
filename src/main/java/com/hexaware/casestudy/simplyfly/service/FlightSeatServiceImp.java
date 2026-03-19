package com.hexaware.casestudy.simplyfly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.casestudy.simplyfly.dto.flight_seat.FlightSeatResponseDto;
import com.hexaware.casestudy.simplyfly.entity.FlightSeat;
import com.hexaware.casestudy.simplyfly.enums.FlightSeatStatus;
import com.hexaware.casestudy.simplyfly.exception.FlightSeatNotFoundException;
import com.hexaware.casestudy.simplyfly.mapper.FlightSeatMapper;
import com.hexaware.casestudy.simplyfly.repository.FlightSeatRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class FlightSeatServiceImp implements IFlightSeatService {
	
	@Autowired
	private FlightSeatRepository repository;

	@Override
	public List<FlightSeatResponseDto> getSeatsByScheduleId(int flightScheduleId) {
		
		return repository.findByFlightSchedule_Id(flightScheduleId).stream().map(entity->{
			return FlightSeatMapper.flightSeatToFlightSeatResponseDto(entity);
		}).toList();
		
	}

	@Override
	public List<FlightSeatResponseDto> getAvailableSeatsByScheduleId(int flightScheduleId) {
		
		return repository.findByFlightSchedule_IdAndStatus(flightScheduleId, FlightSeatStatus.AVAILABLE).stream().map(entity->{
			return FlightSeatMapper.flightSeatToFlightSeatResponseDto(entity);
		}).toList();
		
	}

	@Override
	public FlightSeatResponseDto getFlightSeatById(int id) throws FlightSeatNotFoundException{
		
		FlightSeat flightSeat = repository.findById(id).orElseThrow(()->new FlightSeatNotFoundException("Flight seat not found"));
		
		return FlightSeatMapper.flightSeatToFlightSeatResponseDto(flightSeat);
		
	}

	@Override
	public FlightSeatResponseDto updateSeatStatus(int flightSeatId, FlightSeatStatus status) throws FlightSeatNotFoundException{
		
		FlightSeat flightSeat =  repository.findById(flightSeatId).orElseThrow(()->new FlightSeatNotFoundException("Flight seat not found"));
		
		flightSeat.setStatus(status);
		
		return FlightSeatMapper.flightSeatToFlightSeatResponseDto(repository.save(flightSeat));
		
	}

}
