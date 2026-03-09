package com.hexaware.casestudy.simplyfly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.casestudy.simplyfly.entity.Seat;
import com.hexaware.casestudy.simplyfly.exception.SeatNotFoundException;
import com.hexaware.casestudy.simplyfly.repository.SeatRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SeatServiceImp implements ISeatService {

	@Autowired
	private SeatRepository repository;
	
	@Override
	public List<Seat> getSeatsByAircraftModelId(int aircraftModelId) {
		
		return repository.findByAircraftModel_Id(aircraftModelId);
		
	}

	@Override
	public Seat getSeatById(int id) throws SeatNotFoundException{

		return repository.findById(id).orElseThrow(()->new SeatNotFoundException("Seat record not found"));
	
	}

	@Override
	public Seat addSeat(Seat seat) {
		
		return repository.save(seat);
	
	}

	@Override
	public Seat updateSeat(Seat seat) throws SeatNotFoundException{
		
		repository.findById(seat.getId()).orElseThrow(()->new SeatNotFoundException("Seat record not found"));
		
		return repository.save(seat);
	
	}

	@Override
	public String deleteSeatById(int id) throws SeatNotFoundException{
		
		Seat seat = repository.findById(id).orElseThrow(()->new SeatNotFoundException("Seat record not found"));
		
		repository.delete(seat);
		
		return "Seat record deleted successfully";
		
	}

}
