package com.hexaware.casestudy.simplyfly.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.casestudy.simplyfly.dto.flight_schedule.FlightScheduleCreateDto;
import com.hexaware.casestudy.simplyfly.dto.flight_schedule.FlightScheduleResponseDto;
import com.hexaware.casestudy.simplyfly.entity.Flight;
import com.hexaware.casestudy.simplyfly.entity.FlightSchedule;
import com.hexaware.casestudy.simplyfly.entity.FlightSeat;
import com.hexaware.casestudy.simplyfly.entity.Route;
import com.hexaware.casestudy.simplyfly.entity.User;
import com.hexaware.casestudy.simplyfly.enums.FlightScheduleStatus;
import com.hexaware.casestudy.simplyfly.enums.FlightSeatStatus;
import com.hexaware.casestudy.simplyfly.enums.Role;
import com.hexaware.casestudy.simplyfly.exception.FlightNotFoundException;
import com.hexaware.casestudy.simplyfly.exception.FlightScheduleNotFoundException;
import com.hexaware.casestudy.simplyfly.exception.RouteNotFoundException;
import com.hexaware.casestudy.simplyfly.exception.ServiceNotAllowedException;
import com.hexaware.casestudy.simplyfly.mapper.FlightScheduleMapper;
import com.hexaware.casestudy.simplyfly.repository.FlightRepository;
import com.hexaware.casestudy.simplyfly.repository.FlightScheduleRepository;
import com.hexaware.casestudy.simplyfly.repository.RouteRepository;
import com.hexaware.casestudy.simplyfly.repository.SeatRepository;
import com.hexaware.casestudy.simplyfly.security.CustomUserDetailsService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class FlightScheduleServiceImp implements IFlightScheduleService {
	
	@Autowired
	private FlightScheduleRepository repository;
	
	@Autowired
	private RouteRepository routeRepository;
	
	@Autowired
	private FlightRepository flightRepository;
	
	@Autowired
	private SeatRepository seatRepository;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Override
	public List<FlightScheduleResponseDto> getAllFlightSchedules() {

		return repository.findAll().stream().map(entity->{
			return FlightScheduleMapper.flightScheduleToFlightScheduleResponseDto(entity);
		}).toList();
	
	}

	@Override
	public FlightScheduleResponseDto getFlightScheduleById(int id) throws FlightScheduleNotFoundException {
		
		FlightSchedule schedule = repository.findById(id).orElseThrow(()-> new FlightScheduleNotFoundException("Flight schedule not found"));
		
		return FlightScheduleMapper.flightScheduleToFlightScheduleResponseDto(schedule);
		
	}

	@Override
	public List<FlightScheduleResponseDto> getSchedulesByRouteAndDate(int routeId, LocalDateTime departureDate) {

		return repository.findByRoute_IdAndDepartureDateTime(routeId, departureDate).stream().map(entity->{
			return FlightScheduleMapper.flightScheduleToFlightScheduleResponseDto(entity);
		}).toList();
	
	}

	@Override
	public List<FlightScheduleResponseDto> getSchedulesByFlightId(int flightId) {

		return repository.findByFlight_Id(flightId).stream().map(entity->{
			return FlightScheduleMapper.flightScheduleToFlightScheduleResponseDto(entity);
		}).toList();
	
	}

	@Override
	public FlightScheduleResponseDto addFlightSchedule(FlightScheduleCreateDto flightScheduleCreateDTO) throws FlightNotFoundException,RouteNotFoundException,ServiceNotAllowedException{
		
		User currentUser = customUserDetailsService.getCurrentUserId();
		
		if(currentUser.getRole() == Role.CUSTOMER) throw new ServiceNotAllowedException("User cant add flight schedule");
		
		Flight flight = flightRepository.findById(flightScheduleCreateDTO.getFlightId()).orElseThrow(()->new FlightNotFoundException("flight not found"));
		Route route = routeRepository.findById(flightScheduleCreateDTO.getRouteId()).orElseThrow(()->new RouteNotFoundException("route not found"));
		
		if(currentUser.getRole() == Role.FLIGHT_OWNER && flight.getOwner().getId() != currentUser.getId())throw new ServiceNotAllowedException("You cant add other owners flight schedule");
		
		FlightSchedule flightSchedule = FlightScheduleMapper.flightScheduleCreateDtoToFlightSchedule(flightScheduleCreateDTO, flight, route);
		
		seatRepository.findByAircraftModel_Id(flight.getAircraftModel().getId()).forEach((seat)->{
			FlightSeat flightSeat = new FlightSeat();
			flightSeat.setSeat(seat);
			flightSeat.setFlightSchedule(flightSchedule);
			flightSeat.setStatus(FlightSeatStatus.AVAILABLE);
			flightSchedule.getFlightSeats().add(flightSeat);
		});
		
		FlightSchedule savedFlightSchedule = repository.save(flightSchedule);
		
		FlightScheduleResponseDto response = FlightScheduleMapper.flightScheduleToFlightScheduleResponseDto(savedFlightSchedule);

		return response;
	
	}

	@Override
	public FlightScheduleResponseDto updateFlightScheduleStatus(int flightScheduleId, FlightScheduleStatus status) throws FlightScheduleNotFoundException,ServiceNotAllowedException{
		
		User currentUser = customUserDetailsService.getCurrentUserId();
		
		if(currentUser.getRole() == Role.CUSTOMER) throw new ServiceNotAllowedException("User cant change flight schedule data");
		
		FlightSchedule flightSchedule = repository.findById(flightScheduleId).orElseThrow(()-> new FlightScheduleNotFoundException("Flight schedule not found"));
		
		if(currentUser.getRole() == Role.FLIGHT_OWNER && flightSchedule.getFlight().getOwner().getId() != currentUser.getId())throw new ServiceNotAllowedException("You cant change other owners flight schedule data");
		
		flightSchedule.setStatus(status);
		
		return FlightScheduleMapper.flightScheduleToFlightScheduleResponseDto(repository.save(flightSchedule));
		
	}

	@Override
	public String cancelFlightSchedule(int id) throws FlightScheduleNotFoundException,ServiceNotAllowedException{
		
		User currentUser = customUserDetailsService.getCurrentUserId();
		
		if(currentUser.getRole() == Role.CUSTOMER) throw new ServiceNotAllowedException("User cant cancel flight schedule data");
		
		FlightSchedule flightSchedule = repository.findById(id).orElseThrow(()-> new FlightScheduleNotFoundException("Flight schedule not found"));
		
		if(currentUser.getRole() == Role.FLIGHT_OWNER && flightSchedule.getFlight().getOwner().getId() != currentUser.getId())throw new ServiceNotAllowedException("You cant cancel other owners flight schedule");
		
		flightSchedule.setStatus(FlightScheduleStatus.CANCELLED);
		
		repository.save(flightSchedule);
		
		return "flight schedule cancelled successfully";
	
	}

}
