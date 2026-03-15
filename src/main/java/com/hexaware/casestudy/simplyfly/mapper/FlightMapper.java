package com.hexaware.casestudy.simplyfly.mapper;

import com.hexaware.casestudy.simplyfly.dto.flight.FlightAddingRequestDto;
import com.hexaware.casestudy.simplyfly.dto.flight.FlightResponseDto;
import com.hexaware.casestudy.simplyfly.entity.AircraftModel;
import com.hexaware.casestudy.simplyfly.entity.Flight;
import com.hexaware.casestudy.simplyfly.entity.User;

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

	public static Flight flightAddingRequestDtoToFlight(FlightAddingRequestDto dto,User owner,AircraftModel aircraftModel) {
		
		if(dto == null)return null;
		
		Flight flight = new Flight();
		flight.setFlightNumber(dto.getFlightNumber());
		flight.setOwner(owner);
		flight.setAircraftModel(aircraftModel);
		flight.setActive(dto.isActive());
		
		return flight;
	}
}
