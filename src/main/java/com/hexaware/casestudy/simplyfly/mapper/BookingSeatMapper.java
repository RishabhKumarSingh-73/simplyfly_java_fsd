package com.hexaware.casestudy.simplyfly.mapper;

import com.hexaware.casestudy.simplyfly.dto.booking_seat.BookingSeatRequestDto;
import com.hexaware.casestudy.simplyfly.dto.booking_seat.BookingSeatResponseDto;
import com.hexaware.casestudy.simplyfly.entity.Booking;
import com.hexaware.casestudy.simplyfly.entity.BookingSeat;
import com.hexaware.casestudy.simplyfly.entity.FlightSeat;

public class BookingSeatMapper {

	public static BookingSeat bookingSeatRequestDtoToBookingSeat(BookingSeatRequestDto dto,Booking booking,FlightSeat flightSeat) {
		
		if(dto==null)return null;
		
		BookingSeat bookingSeat = new BookingSeat();
		bookingSeat.setBooking(booking);
		bookingSeat.setFlightSeat(flightSeat);
		bookingSeat.setPricePaid(dto.getPricePaid());
		
		return bookingSeat;
		
	}
	
	public static BookingSeatResponseDto bookingToBookingSeatResponseDto(BookingSeat bookingSeat) {
		
		if(bookingSeat == null)return null;
		
		BookingSeatResponseDto dto = new BookingSeatResponseDto();
		dto.setId(bookingSeat.getId());
		dto.setBookingId(bookingSeat.getBooking().getId());
		dto.setFlightSeatId(bookingSeat.getFlightSeat().getId());
		dto.setPricePaid(bookingSeat.getPricePaid());
		
		return dto;
	}
}
