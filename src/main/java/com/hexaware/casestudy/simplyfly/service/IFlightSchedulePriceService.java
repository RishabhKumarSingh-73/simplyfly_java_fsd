package com.hexaware.casestudy.simplyfly.service;

import java.util.List;

import com.hexaware.casestudy.simplyfly.dto.flight_schedule_price.FlightSchedulePriceAddingRequestDto;
import com.hexaware.casestudy.simplyfly.dto.flight_schedule_price.FlightSchedulePriceResponseDto;
import com.hexaware.casestudy.simplyfly.enums.SeatClass;
import com.hexaware.casestudy.simplyfly.exception.FlightSchedulePriceNotFoundException;

public interface IFlightSchedulePriceService {
	
	List<FlightSchedulePriceResponseDto> getPricesByScheduleId(int flightScheduleId);
    FlightSchedulePriceResponseDto getPriceByScheduleAndClass(int flightScheduleId, SeatClass seatClass)throws FlightSchedulePriceNotFoundException;
    FlightSchedulePriceResponseDto addPrice(FlightSchedulePriceAddingRequestDto priceDto);
}
