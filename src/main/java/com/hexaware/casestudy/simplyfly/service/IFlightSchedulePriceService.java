package com.hexaware.casestudy.simplyfly.service;

import java.util.List;

import com.hexaware.casestudy.simplyfly.entity.FlightSchedulePrice;
import com.hexaware.casestudy.simplyfly.enums.SeatClass;
import com.hexaware.casestudy.simplyfly.exception.FlightSchedulePriceNotFoundException;

public interface IFlightSchedulePriceService {
	
	List<FlightSchedulePrice> getPricesByScheduleId(int flightScheduleId);
    FlightSchedulePrice getPriceByScheduleAndClass(int flightScheduleId, SeatClass seatClass)throws FlightSchedulePriceNotFoundException;
    FlightSchedulePrice addPrice(FlightSchedulePrice price);
    FlightSchedulePrice updatePrice(FlightSchedulePrice price)throws FlightSchedulePriceNotFoundException;
    String deletePriceById(int id)throws FlightSchedulePriceNotFoundException;
}
