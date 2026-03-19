package com.hexaware.casestudy.simplyfly.service;

import java.util.List;

import com.hexaware.casestudy.simplyfly.dto.booking.BookingRequestDto;
import com.hexaware.casestudy.simplyfly.entity.Booking;
import com.hexaware.casestudy.simplyfly.enums.BookingStatus;
import com.hexaware.casestudy.simplyfly.exception.BookingNotFoundException;

public interface IBookingService {
	
	List<Booking> getAllBookings();
    Booking getBookingById(int id)throws BookingNotFoundException;
    List<Booking> getBookingsByUserId(int userId);
    Booking addBooking(BookingRequestDto bookingDto);
    Booking updateBookingStatus(int bookingId, BookingStatus status)throws BookingNotFoundException;
    String cancelBooking(int bookingId)throws BookingNotFoundException;
    
}
