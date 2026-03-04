package com.hexaware.casestudy.simplyfly.service;

import java.time.LocalDateTime;
import java.util.List;

import com.hexaware.casestudy.simplyfly.entity.FlightSchedule;

public interface IFlightScheduleService {
	
	List<FlightSchedule> getAllFlightSchedules();
    FlightSchedule getFlightScheduleById(int id);
    List<FlightSchedule> getSchedulesByRouteAndDate(int routeId, LocalDateTime departureDate);
    List<FlightSchedule> getSchedulesByFlightId(int flightId);
    int addFlightSchedule(FlightSchedule flightSchedule);
    int updateFlightSchedule(FlightSchedule flightSchedule);
    int cancelFlightSchedule(int id);
}
