package com.hexaware.casestudy.simplyfly.mapper;

import java.util.List;

import com.hexaware.casestudy.simplyfly.dto.booking.BookingRequestDto;
import com.hexaware.casestudy.simplyfly.dto.booking.BookingResponseDto;
import com.hexaware.casestudy.simplyfly.dto.booking_seat.BookingSeatResponseDto;
import com.hexaware.casestudy.simplyfly.entity.Booking;
import com.hexaware.casestudy.simplyfly.entity.BookingSeat;
import com.hexaware.casestudy.simplyfly.entity.FlightSchedule;
import com.hexaware.casestudy.simplyfly.entity.User;

public class BookingMapper {
	
	public static Booking bookingRequestDtoToBooking(BookingRequestDto dto,User user,FlightSchedule flightSchedule,List<BookingSeat> bookedSeats) {
		
		if(dto==null)return null;
		
		Booking booking = new Booking();
		booking.setUser(user);
		booking.setFlightSchedule(flightSchedule);
		booking.setStatus(dto.getStatus());
		booking.setTotalAmount(dto.getTotalAmount());
		booking.setBookedSeats(bookedSeats);
		
		return booking;
	}
	
	public static BookingResponseDto bookingToBookingResponseDto(Booking booking,List<BookingSeatResponseDto> bookedSeats) {
		
		if(booking==null)return null;
		
		BookingResponseDto dto = new BookingResponseDto();
		dto.setId(booking.getId());
		dto.setUserId(booking.getUser().getId());
		dto.setFlightScheduleId(booking.getFlightSchedule().getId());
		dto.setStatus(booking.getStatus());
		dto.setTotalAmount(booking.getTotalAmount());
		dto.setBookedSeats(bookedSeats);
		
		return dto;
		
	}

}
