package com.hexaware.casestudy.simplyfly.service;

import java.time.LocalDateTime;
import java.util.List;

import com.hexaware.casestudy.simplyfly.entity.FlightSchedule;

public class FlightScheduleServiceImp implements IFlightScheduleService {

	@Override
	public List<FlightSchedule> getAllFlightSchedules() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FlightSchedule getFlightScheduleById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FlightSchedule> getSchedulesByRouteAndDate(int routeId, LocalDateTime departureDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FlightSchedule> getSchedulesByFlightId(int flightId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addFlightSchedule(FlightSchedule flightSchedule) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateFlightSchedule(FlightSchedule flightSchedule) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int cancelFlightSchedule(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
