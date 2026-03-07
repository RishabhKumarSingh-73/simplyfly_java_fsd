package com.hexaware.casestudy.simplyfly.service;

import java.util.List;

import com.hexaware.casestudy.simplyfly.entity.Seat;
import com.hexaware.casestudy.simplyfly.exception.SeatNotFoundException;

public interface ISeatService {
	
	List<Seat> getSeatsByAircraftModelId(int aircraftModelId);
    Seat getSeatById(int id)throws SeatNotFoundException;
    Seat addSeat(Seat seat);
    Seat updateSeat(Seat seat)throws SeatNotFoundException;
    String deleteSeatById(int id)throws SeatNotFoundException;
    
}
