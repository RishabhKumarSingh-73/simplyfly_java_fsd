package com.hexaware.casestudy.simplyfly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.casestudy.simplyfly.dto.flight_schedule_price.FlightSchedulePriceAddingRequestDto;
import com.hexaware.casestudy.simplyfly.dto.flight_schedule_price.FlightSchedulePriceResponseDto;
import com.hexaware.casestudy.simplyfly.entity.FlightSchedule;
import com.hexaware.casestudy.simplyfly.entity.FlightSchedulePrice;
import com.hexaware.casestudy.simplyfly.entity.User;
import com.hexaware.casestudy.simplyfly.enums.Role;
import com.hexaware.casestudy.simplyfly.enums.SeatClass;
import com.hexaware.casestudy.simplyfly.exception.FlightScheduleNotFoundException;
import com.hexaware.casestudy.simplyfly.exception.FlightSchedulePriceNotFoundException;
import com.hexaware.casestudy.simplyfly.exception.ServiceNotAllowedException;
import com.hexaware.casestudy.simplyfly.mapper.FlightSchedulePriceMapper;
import com.hexaware.casestudy.simplyfly.repository.FlightSchedulePriceRepository;
import com.hexaware.casestudy.simplyfly.repository.FlightScheduleRepository;
import com.hexaware.casestudy.simplyfly.security.CustomUserDetailsService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class FlightSchedulePriceServiceImp implements IFlightSchedulePriceService {
	
	@Autowired
	private FlightSchedulePriceRepository repository;
	
	@Autowired
	private FlightScheduleRepository flightScheduleRepo;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Override
	public List<FlightSchedulePriceResponseDto> getPricesByScheduleId(int flightScheduleId) {
		
		return repository.findByFlightSchedule_Id(flightScheduleId).stream().map(entity->{
			return FlightSchedulePriceMapper.flightSchedulePriceToFlightSchedulePriceResponseDto(entity);
		}).toList();
		
	}

	@Override
	public FlightSchedulePriceResponseDto getPriceByScheduleAndClass(int flightScheduleId, SeatClass seatClass) throws FlightSchedulePriceNotFoundException{

		FlightSchedulePrice price = repository.findByFlightSchedule_IdAndSeatClass(flightScheduleId, seatClass).orElseThrow(()-> new FlightSchedulePriceNotFoundException("flight schedule price record not found"));
		
		return FlightSchedulePriceMapper.flightSchedulePriceToFlightSchedulePriceResponseDto(price);
	
	}

	@Override
	public FlightSchedulePriceResponseDto addPrice(FlightSchedulePriceAddingRequestDto priceDto)throws FlightScheduleNotFoundException,ServiceNotAllowedException {
		
		User currentUser = customUserDetailsService.getCurrentUserId();
		
		if(currentUser.getRole() == Role.CUSTOMER) throw new ServiceNotAllowedException("User cant add price to flight schedule");
		
		FlightSchedule schedule = flightScheduleRepo.findById(priceDto.getFlightScheduleId()).orElseThrow(()->new FlightScheduleNotFoundException(null));
		
		if(currentUser.getRole() == Role.FLIGHT_OWNER && schedule.getFlight().getOwner().getId() != currentUser.getId())throw new ServiceNotAllowedException("You cant add price to other owners flight schedule");
		
		FlightSchedulePrice price = FlightSchedulePriceMapper.flightSchedulePriceAddingRequestDtoToFlightSchedulePrice(priceDto, schedule);

		return FlightSchedulePriceMapper.flightSchedulePriceToFlightSchedulePriceResponseDto(price);
		
	}

	

}
