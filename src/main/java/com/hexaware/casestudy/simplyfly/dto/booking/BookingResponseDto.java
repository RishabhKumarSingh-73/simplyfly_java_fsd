package com.hexaware.casestudy.simplyfly.dto.booking;

import java.util.List;

import com.hexaware.casestudy.simplyfly.dto.booking_seat.BookingSeatResponseDto;
import com.hexaware.casestudy.simplyfly.enums.BookingStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingResponseDto {

	private int id;
	private int userId;
	private int flightScheduleId;
	private BookingStatus status;
	private double totalAmount;
	private List<BookingSeatResponseDto> bookedSeats;
	
}
