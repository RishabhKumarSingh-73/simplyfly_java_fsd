package com.hexaware.casestudy.simplyfly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.casestudy.simplyfly.entity.FlightSchedulePrice;
import com.hexaware.casestudy.simplyfly.enums.SeatClass;
import com.hexaware.casestudy.simplyfly.exception.FlightSchedulePriceNotFoundException;
import com.hexaware.casestudy.simplyfly.repository.FlightSchedulePriceRepository;

@Service
public class FlightSchedulePriceServiceImp implements IFlightSchedulePriceService {
	
	@Autowired
	private FlightSchedulePriceRepository repository;

	@Override
	public List<FlightSchedulePrice> getPricesByScheduleId(int flightScheduleId) {
		
		return repository.findByFlightSchedule_Id(flightScheduleId);
		
	}

	@Override
	public FlightSchedulePrice getPriceByScheduleAndClass(int flightScheduleId, SeatClass seatClass) throws FlightSchedulePriceNotFoundException{

		return repository.findByFlightSchedule_IdAndSeatClass(flightScheduleId, seatClass).orElseThrow(()-> new FlightSchedulePriceNotFoundException("flight schedule price record not found"));
	
	}

	@Override
	public FlightSchedulePrice addPrice(FlightSchedulePrice price) {

		return repository.save(price);
		
	}

	@Override
	public FlightSchedulePrice updatePrice(FlightSchedulePrice price) throws FlightSchedulePriceNotFoundException{
		
		repository.findById(price.getId()).orElseThrow(()-> new FlightSchedulePriceNotFoundException("flight schedule price record not found"));
		
		return repository.save(price);
		
	}

	@Override
	public String deletePriceById(int id) throws FlightSchedulePriceNotFoundException{
		
		FlightSchedulePrice price = repository.findById(id).orElseThrow(()-> new FlightSchedulePriceNotFoundException("flight schedule price record not found"));
		
		repository.delete(price);
		
		return "flight schedule price deleted successfully";
		
	}

}
