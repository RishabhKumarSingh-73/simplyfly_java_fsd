package com.hexaware.casestudy.simplyfly.mapper;

import com.hexaware.casestudy.simplyfly.dto.flight.FlightResponseDto;
import com.hexaware.casestudy.simplyfly.entity.Flight;

public class FlightMapper {

	public static FlightResponseDto flightToFlightResponseDto(Flight flight) {
		
		if(flight == null)return null;
		
		FlightResponseDto dto = new FlightResponseDto();
		dto.setId(flight.getId());
		dto.setFlightNumber(flight.getFlightNumber());
		dto.setOwner(flight.getOwner());
		dto.setAircraftModel(flight.getAircraftModel());
		dto.setActive(flight.isActive());
		
		return dto;
	}
}
