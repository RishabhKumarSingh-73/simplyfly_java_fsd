package com.hexaware.casestudy.simplyfly.mapper;

import com.hexaware.casestudy.simplyfly.dto.seat.SeatAddingRequestDto;
import com.hexaware.casestudy.simplyfly.dto.seat.SeatResponseDto;
import com.hexaware.casestudy.simplyfly.entity.AircraftModel;
import com.hexaware.casestudy.simplyfly.entity.Seat;

public class SeatMapper {

	public static SeatResponseDto seatToSeatResponseDto(Seat seat) {
		
		if(seat==null)return null;
		
		SeatResponseDto dto = new SeatResponseDto();
		dto.setId(seat.getId());
		dto.setAircraftModelId(seat.getAircraftModel().getId());
		dto.setRowNumber(seat.getRowNumber());
		dto.setColumnLetter(seat.getColumnLetter());
		dto.setPositionType(seat.getPositionType());
		dto.setSeatClass(seat.getSeatClass());
		
		return dto;
		
	}
	
	public static Seat seatAddingRequestDtoToSeat(SeatAddingRequestDto dto,AircraftModel aircraftModel) {
		
		if(dto==null)return null;
		
		Seat seat = new Seat();
		seat.setAircraftModel(aircraftModel);
		seat.setRowNumber(dto.getRowNumber());
		seat.setColumnLetter(dto.getColumnLetter());
		seat.setPositionType(dto.getPositionType());
		seat.setSeatClass(dto.getSeatClass());
		
		return seat;
		
	}
}
