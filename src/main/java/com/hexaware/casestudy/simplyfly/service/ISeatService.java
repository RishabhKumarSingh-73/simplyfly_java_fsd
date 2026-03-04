package com.hexaware.casestudy.simplyfly.service;

import java.util.List;

import com.hexaware.casestudy.simplyfly.entity.Seat;

public interface ISeatService {
	
	List<Seat> getSeatsByAircraftModelId(int aircraftModelId);
    Seat getSeatById(int id);
    int addSeat(Seat seat);
    int updateSeat(Seat seat);
    int deleteSeatById(int id);
}
