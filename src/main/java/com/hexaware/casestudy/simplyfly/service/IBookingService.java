package com.hexaware.casestudy.simplyfly.service;

import java.util.List;

import com.hexaware.casestudy.simplyfly.entity.Booking;

public interface IBookingService {
	
	List<Booking> getAllBookings();
    Booking getBookingById(int id);
    List<Booking> getBookingsByUserId(int userId);
    int addBooking(Booking booking);
    int updateBookingStatus(int bookingId, String status);
    int cancelBooking(int bookingId);
    
}
