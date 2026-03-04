package com.hexaware.casestudy.simplyfly.service;

import java.util.List;

import com.hexaware.casestudy.simplyfly.entity.FlightSchedulePrice;

public interface IFlightSchedulePriceService {
	
	List<FlightSchedulePrice> getPricesByScheduleId(int flightScheduleId);
    FlightSchedulePrice getPriceByScheduleAndClass(int flightScheduleId, String seatClass);
    int addPrice(FlightSchedulePrice price);
    int updatePrice(FlightSchedulePrice price);
    int deletePriceById(int id);
}
