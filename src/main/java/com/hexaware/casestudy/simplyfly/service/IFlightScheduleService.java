package com.hexaware.casestudy.simplyfly.service;

import java.time.LocalDateTime;
import java.util.List;

import com.hexaware.casestudy.simplyfly.dto.FlightScheduleCreateDTO;
import com.hexaware.casestudy.simplyfly.dto.FlightScheduleResponseDTO;
import com.hexaware.casestudy.simplyfly.entity.FlightSchedule;
import com.hexaware.casestudy.simplyfly.enums.FlightScheduleStatus;
import com.hexaware.casestudy.simplyfly.exception.FlightNotFoundException;
import com.hexaware.casestudy.simplyfly.exception.FlightScheduleNotFoundException;
import com.hexaware.casestudy.simplyfly.exception.RouteNotFoundException;

public interface IFlightScheduleService {
	
	List<FlightSchedule> getAllFlightSchedules();
    FlightSchedule getFlightScheduleById(int id)throws FlightScheduleNotFoundException;
    List<FlightSchedule> getSchedulesByRouteAndDate(int routeId, LocalDateTime departureDate);
    List<FlightSchedule> getSchedulesByFlightId(int flightId);
    FlightScheduleResponseDTO addFlightSchedule(FlightScheduleCreateDTO flightScheduleCreateDTO)throws FlightNotFoundException,RouteNotFoundException;
    FlightSchedule updateFlightScheduleStatus(int flightScheduleId, FlightScheduleStatus status)throws FlightScheduleNotFoundException;
    String cancelFlightSchedule(int id)throws FlightScheduleNotFoundException;
}
