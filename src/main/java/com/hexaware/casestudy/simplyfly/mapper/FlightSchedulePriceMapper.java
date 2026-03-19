package com.hexaware.casestudy.simplyfly.mapper;

import com.hexaware.casestudy.simplyfly.dto.flight_schedule_price.FlightSchedulePriceDTO;
import com.hexaware.casestudy.simplyfly.dto.flight_schedule_price.FlightSchedulePriceResponseDto;
import com.hexaware.casestudy.simplyfly.dto.flight_schedule_price.FlightSchedulePriceAddingRequestDto;
import com.hexaware.casestudy.simplyfly.entity.FlightSchedule;
import com.hexaware.casestudy.simplyfly.entity.FlightSchedulePrice;

public class FlightSchedulePriceMapper {

	public static FlightSchedulePriceDTO flightSchedulePriceToFlightSchedulePriceDTO(FlightSchedulePrice flightSchedulePrice) {
		
		if(flightSchedulePrice == null)return null;
		
		FlightSchedulePriceDTO dto = new FlightSchedulePriceDTO();
		dto.setSeatClass(flightSchedulePrice.getSeatClass());
		dto.setBasePrice(flightSchedulePrice.getBasePrice());
		
		return dto;
	
	}
	
	public static FlightSchedulePrice flightSchedulePriceDtoToFlightSchedulePrice(FlightSchedulePriceDTO dto) {
		
		if(dto == null)return null;
		
		FlightSchedulePrice flightSchedulePrice = new FlightSchedulePrice();
		flightSchedulePrice.setSeatClass(dto.getSeatClass());
		flightSchedulePrice.setBasePrice(dto.getBasePrice());
		
		return flightSchedulePrice;
	
	}

	public static FlightSchedulePrice flightSchedulePriceAddingRequestDtoToFlightSchedulePrice(FlightSchedulePriceAddingRequestDto dto,FlightSchedule flightSchedule){

		if(dto == null)return null;

		FlightSchedulePrice flightSchedulePrice = new FlightSchedulePrice();
		flightSchedulePrice.setFlightSchedule(flightSchedule);
		flightSchedulePrice.setSeatClass(dto.getSeatClass());
		flightSchedulePrice.setBasePrice(dto.getBasePrice());

		return flightSchedulePrice;

	}

public static FlightSchedulePriceResponseDto flightSchedulePriceToFlightSchedulePriceResponseDto(FlightSchedulePrice flightSchedulePrice) {

	if(flightSchedulePrice == null)return null;

	FlightSchedulePriceResponseDto dto = new FlightSchedulePriceResponseDto();
	dto.setId(flightSchedulePrice.getId());
	dto.setBasePrice(flightSchedulePrice.getBasePrice());
	dto.setFlightScheduleId(flightSchedulePrice.getFlightSchedule().getId());
	dto.setSeatClass(flightSchedulePrice.getSeatClass());

	return dto;
}
}
