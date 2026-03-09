package com.hexaware.casestudy.simplyfly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.casestudy.simplyfly.entity.FlightSeat;
import com.hexaware.casestudy.simplyfly.enums.FlightSeatStatus;
import com.hexaware.casestudy.simplyfly.exception.FlightSeatNotFoundException;
import com.hexaware.casestudy.simplyfly.repository.FlightSeatRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class FlightSeatServiceImp implements IFlightSeatService {
	
	@Autowired
	private FlightSeatRepository repository;

	@Override
	public List<FlightSeat> getSeatsByScheduleId(int flightScheduleId) {
		
		return repository.findByFlightSchedule_Id(flightScheduleId);
		
	}

	@Override
	public List<FlightSeat> getAvailableSeatsByScheduleId(int flightScheduleId) {
		
		return repository.findByFlightSchedule_IdAndStatus(flightScheduleId, FlightSeatStatus.AVAILABLE);
		
	}

	@Override
	public FlightSeat getFlightSeatById(int id) throws FlightSeatNotFoundException{
		
		return repository.findById(id).orElseThrow(()->new FlightSeatNotFoundException("Flight seat not found"));
		
	}

	@Override
	public FlightSeat updateSeatStatus(int flightSeatId, FlightSeatStatus status) throws FlightSeatNotFoundException{
		
		FlightSeat flightSeat =  repository.findById(flightSeatId).orElseThrow(()->new FlightSeatNotFoundException("Flight seat not found"));
		
		flightSeat.setStatus(status);
		
		return repository.save(flightSeat);
		
	}

}
