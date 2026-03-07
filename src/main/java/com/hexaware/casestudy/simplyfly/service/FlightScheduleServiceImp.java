package com.hexaware.casestudy.simplyfly.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.casestudy.simplyfly.dto.FlightScheduleCreateDTO;
import com.hexaware.casestudy.simplyfly.dto.FlightSchedulePriceDTO;
import com.hexaware.casestudy.simplyfly.dto.FlightScheduleResponseDTO;
import com.hexaware.casestudy.simplyfly.entity.Flight;
import com.hexaware.casestudy.simplyfly.entity.FlightSchedule;
import com.hexaware.casestudy.simplyfly.entity.FlightSchedulePrice;
import com.hexaware.casestudy.simplyfly.entity.FlightSeat;
import com.hexaware.casestudy.simplyfly.entity.Route;
import com.hexaware.casestudy.simplyfly.enums.FlightScheduleStatus;
import com.hexaware.casestudy.simplyfly.enums.FlightSeatStatus;
import com.hexaware.casestudy.simplyfly.exception.FlightNotFoundException;
import com.hexaware.casestudy.simplyfly.exception.FlightScheduleNotFoundException;
import com.hexaware.casestudy.simplyfly.exception.RouteNotFoundException;
import com.hexaware.casestudy.simplyfly.repository.FlightRepository;
import com.hexaware.casestudy.simplyfly.repository.FlightScheduleRepository;
import com.hexaware.casestudy.simplyfly.repository.RouteRepository;
import com.hexaware.casestudy.simplyfly.repository.SeatRepository;

@Service
public class FlightScheduleServiceImp implements IFlightScheduleService {
	
	@Autowired
	private FlightScheduleRepository repository;
	
	@Autowired
	private RouteRepository routeRepository;
	
	@Autowired
	private FlightRepository flightRepository;
	
	@Autowired
	private SeatRepository seatRepository;

	@Override
	public List<FlightSchedule> getAllFlightSchedules() {

		return repository.findAll();
	
	}

	@Override
	public FlightSchedule getFlightScheduleById(int id) throws FlightScheduleNotFoundException {
		
		return repository.findById(id).orElseThrow(()-> new FlightScheduleNotFoundException("Flight schedule not found"));
		
	}

	@Override
	public List<FlightSchedule> getSchedulesByRouteAndDate(int routeId, LocalDateTime departureDate) {

		return repository.findByRoute_IdAndDepartureDateTime(routeId, departureDate);
	
	}

	@Override
	public List<FlightSchedule> getSchedulesByFlightId(int flightId) {

		return repository.findByFlight_Id(flightId);
	
	}

	@Override
	public FlightScheduleResponseDTO addFlightSchedule(FlightScheduleCreateDTO flightScheduleCreateDTO) throws FlightNotFoundException,RouteNotFoundException{
		
		Flight flight = flightRepository.findById(flightScheduleCreateDTO.getFlightId()).orElseThrow(()->new FlightNotFoundException("flight not found"));
		Route route = routeRepository.findById(flightScheduleCreateDTO.getRouteId()).orElseThrow(()->new RouteNotFoundException("route not found"));
		
		FlightSchedule flightSchedule = new FlightSchedule();
		
		flightSchedule.setFlight(flight);
		flightSchedule.setRoute(route);
		flightSchedule.setDepartureDateTime(flightScheduleCreateDTO.getDepartureDatetime());
		flightSchedule.setArivalDateTime(flightScheduleCreateDTO.getArrivalDatetime());
		flightSchedule.setStatus(FlightScheduleStatus.SCHEDULED);
		
		
		flightScheduleCreateDTO.getPrices().forEach((price)->{
			FlightSchedulePrice schedulePrice = new FlightSchedulePrice();
			schedulePrice.setSeatClass(price.getSeatClass());
			schedulePrice.setBasePrice(price.getBasePrice());
			schedulePrice.setFlightSchedule(flightSchedule);
			
			flightSchedule.getFlightSchedulePrices().add(schedulePrice);
		});
		
		seatRepository.findByAircraftModel_Id(flight.getAircraftModel().getId()).forEach((seat)->{
			FlightSeat flightSeat = new FlightSeat();
			flightSeat.setSeat(seat);
			flightSeat.setFlightSchedule(flightSchedule);
			flightSeat.setStatus(FlightSeatStatus.AVAILABLE);
			flightSchedule.getFlightSeats().add(flightSeat);
		});
		
		FlightSchedule savedFlightSchedule = repository.save(flightSchedule);
		
		FlightScheduleResponseDTO response = new FlightScheduleResponseDTO();

		response.setScheduleId(savedFlightSchedule.getId());
		response.setFlightId(savedFlightSchedule.getFlight().getId());
		response.setRouteId(savedFlightSchedule.getRoute().getId());
		response.setDepartureDatetime(savedFlightSchedule.getDepartureDateTime());
		response.setArrivalDatetime(savedFlightSchedule.getArivalDateTime());
		response.setStatus(savedFlightSchedule.getStatus().name());
		
		List<FlightSchedulePriceDTO> prices =
		        savedFlightSchedule.getFlightSchedulePrices()
		        .stream()
		        .map(price -> {
		            FlightSchedulePriceDTO dto = new FlightSchedulePriceDTO();
		            dto.setSeatClass(price.getSeatClass());
		            dto.setBasePrice(price.getBasePrice());
		            return dto;
		        })
		        .toList();
		
		response.setPrices(prices);

		return response;
	
	}

	@Override
	public FlightSchedule updateFlightScheduleStatus(int flightScheduleId, FlightScheduleStatus status) throws FlightScheduleNotFoundException{
		
		FlightSchedule flightSchedule = repository.findById(flightScheduleId).orElseThrow(()-> new FlightScheduleNotFoundException("Flight schedule not found"));
		
		flightSchedule.setStatus(status);
		
		return repository.save(flightSchedule);
		
	}

	@Override
	public String cancelFlightSchedule(int id) throws FlightScheduleNotFoundException{
		
		FlightSchedule flightSchedule = repository.findById(id).orElseThrow(()-> new FlightScheduleNotFoundException("Flight schedule not found"));
		
		flightSchedule.setStatus(FlightScheduleStatus.CANCELLED);
		
		repository.save(flightSchedule);
		
		return "flight schedule cancelled successfully";
	
	}

}
