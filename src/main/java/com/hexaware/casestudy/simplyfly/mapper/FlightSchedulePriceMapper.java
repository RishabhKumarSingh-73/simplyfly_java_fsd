package com.hexaware.casestudy.simplyfly.mapper;

import com.hexaware.casestudy.simplyfly.dto.flight_schedule_price.FlightSchedulePriceDTO;
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
}
