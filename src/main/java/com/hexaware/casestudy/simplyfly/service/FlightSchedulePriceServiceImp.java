package com.hexaware.casestudy.simplyfly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.casestudy.simplyfly.dto.flight_schedule_price.FlightSchedulePriceAddingRequestDto;
import com.hexaware.casestudy.simplyfly.entity.FlightSchedulePrice;
import com.hexaware.casestudy.simplyfly.enums.SeatClass;
import com.hexaware.casestudy.simplyfly.exception.FlightSchedulePriceNotFoundException;
import com.hexaware.casestudy.simplyfly.repository.FlightSchedulePriceRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
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
	public FlightSchedulePrice addPrice(FlightSchedulePriceAddingRequestDto priceDto) {

		return repository.save(priceDto);
		
	}

	

}
