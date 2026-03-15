package com.hexaware.casestudy.simplyfly.service;

import java.time.LocalDateTime;
import java.util.List;

import com.hexaware.casestudy.simplyfly.dto.flight_schedule.FlightScheduleCreateDto;
import com.hexaware.casestudy.simplyfly.dto.flight_schedule.FlightScheduleResponseDto;
import com.hexaware.casestudy.simplyfly.enums.FlightScheduleStatus;
import com.hexaware.casestudy.simplyfly.exception.FlightNotFoundException;
import com.hexaware.casestudy.simplyfly.exception.FlightScheduleNotFoundException;
import com.hexaware.casestudy.simplyfly.exception.RouteNotFoundException;

public interface IFlightScheduleService {
	
	List<FlightScheduleResponseDto> getAllFlightSchedules();
	FlightScheduleResponseDto getFlightScheduleById(int id)throws FlightScheduleNotFoundException;
    List<FlightScheduleResponseDto> getSchedulesByRouteAndDate(int routeId, LocalDateTime departureDate);
    List<FlightScheduleResponseDto> getSchedulesByFlightId(int flightId);
    FlightScheduleResponseDto addFlightSchedule(FlightScheduleCreateDto flightScheduleCreateDTO)throws FlightNotFoundException,RouteNotFoundException;
    FlightScheduleResponseDto updateFlightScheduleStatus(int flightScheduleId, FlightScheduleStatus status)throws FlightScheduleNotFoundException;
    String cancelFlightSchedule(int id)throws FlightScheduleNotFoundException;
    
}
