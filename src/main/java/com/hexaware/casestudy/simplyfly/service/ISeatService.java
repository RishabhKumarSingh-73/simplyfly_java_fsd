package com.hexaware.casestudy.simplyfly.service;

import java.util.List;

import com.hexaware.casestudy.simplyfly.dto.seat.SeatAddingRequestDto;
import com.hexaware.casestudy.simplyfly.dto.seat.SeatResponseDto;
import com.hexaware.casestudy.simplyfly.exception.AircraftModelNotFoundException;
import com.hexaware.casestudy.simplyfly.exception.SeatNotFoundException;

public interface ISeatService {
	
	List<SeatResponseDto> getSeatsByAircraftModelId(int aircraftModelId);
	SeatResponseDto getSeatById(int id)throws SeatNotFoundException;
	SeatResponseDto addSeat(SeatAddingRequestDto seatDto)throws AircraftModelNotFoundException;
	
//	SeatResponseDto updateSeat(SeatAddingRequestDto seatDto,int id)throws SeatNotFoundException;
//    String deleteSeatById(int id)throws SeatNotFoundException;
    
}
