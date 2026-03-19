package com.hexaware.casestudy.simplyfly.mapper;

import com.hexaware.casestudy.simplyfly.dto.flight_seat.FlightSeatResponseDto;
import com.hexaware.casestudy.simplyfly.entity.FlightSeat;

public class FlightSeatMapper {

	public static FlightSeatResponseDto flightSeatToFlightSeatResponseDto(FlightSeat seat) {
		
		if(seat==null)return null;
		
		FlightSeatResponseDto dto = new FlightSeatResponseDto();
		dto.setId(seat.getId());
		dto.setSeatId(seat.getSeat().getId());
		dto.setFlightScheduleId(seat.getFlightSchedule().getId());
		dto.setStatus(seat.getStatus());
		
		return dto;
		
	}
	
}
