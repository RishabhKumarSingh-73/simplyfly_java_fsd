package com.hexaware.casestudy.simplyfly.mapper;


import com.hexaware.casestudy.simplyfly.dto.flight_schedule.FlightScheduleCreateDto;
import com.hexaware.casestudy.simplyfly.dto.flight_schedule.FlightScheduleResponseDto;
import com.hexaware.casestudy.simplyfly.entity.Flight;
import com.hexaware.casestudy.simplyfly.entity.FlightSchedule;
import com.hexaware.casestudy.simplyfly.entity.Route;
import com.hexaware.casestudy.simplyfly.enums.FlightScheduleStatus;

public class FlightScheduleMapper {
	
	public static FlightSchedule flightScheduleCreateDtoToFlightSchedule(FlightScheduleCreateDto dto,Flight flight,Route route) {
		
		if(dto==null)return null;
		
		FlightSchedule flightSchedule = new FlightSchedule();
		flightSchedule.setFlight(flight);
		flightSchedule.setRoute(route);
		flightSchedule.setArivalDateTime(dto.getArrivalDatetime());
		flightSchedule.setDepartureDateTime(dto.getDepartureDatetime());
		flightSchedule.setStatus(FlightScheduleStatus.SCHEDULED);
		flightSchedule.setFlightSchedulePrices(dto.getPrices().stream().map(priceDto->{
			return FlightSchedulePriceMapper.flightSchedulePriceDtoToFlightSchedulePrice(priceDto);
		}).toList()
				);
		
		return flightSchedule;
		
	}
	
	public static FlightScheduleResponseDto flightScheduleToFlightScheduleResponseDto(FlightSchedule flightSchedule) {
		
		if(flightSchedule == null)return null;
		
		FlightScheduleResponseDto dto = new FlightScheduleResponseDto();
		dto.setScheduleId(flightSchedule.getId());
		dto.setFlightId(flightSchedule.getFlight().getId());
		dto.setRouteId(flightSchedule.getRoute().getId());
		dto.setArrivalDatetime(flightSchedule.getArivalDateTime());
		dto.setDepartureDatetime(flightSchedule.getDepartureDateTime());
		dto.setStatus(flightSchedule.getStatus());
		
		dto.setPrices(flightSchedule.getFlightSchedulePrices().stream().map(entity->{
			return FlightSchedulePriceMapper.flightSchedulePriceToFlightSchedulePriceDTO(entity);
		}).toList()
				);
		
		return dto;
	}

}
