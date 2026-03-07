package com.hexaware.casestudy.simplyfly.service;

import java.util.List;

import com.hexaware.casestudy.simplyfly.entity.Booking;
import com.hexaware.casestudy.simplyfly.enums.BookingStatus;
import com.hexaware.casestudy.simplyfly.exception.BookingNotFoundException;
import com.hexaware.casestudy.simplyfly.repository.BookingRepository;

public class BookingServiceImp implements IBookingService {
	
	private BookingRepository repository;

	@Override
	public List<Booking> getAllBookings() {

		return repository.findAll();
	
	}

	@Override
	public Booking getBookingById(int id) throws BookingNotFoundException{
		
		return repository.findById(id).orElseThrow(()->new BookingNotFoundException("Booking not found"));
	
	}

	@Override
	public List<Booking> getBookingsByUserId(int userId) {
		
		return repository.findByUser_Id(userId);
		
	}

	@Override
	public Booking addBooking(Booking booking) {
		
		return repository.save(booking);
		
	}

	@Override
	public Booking updateBookingStatus(int bookingId, BookingStatus status) throws BookingNotFoundException{
		
		Booking booking = repository.findById(bookingId).orElseThrow(()->new BookingNotFoundException("Booking not found"));
		
		booking.setStatus(status);
		
		return repository.save(booking);
		
	}

	@Override
	public String cancelBooking(int bookingId) throws BookingNotFoundException{
		
		Booking booking = repository.findById(bookingId).orElseThrow(()->new BookingNotFoundException("Booking not found"));
		
		booking.setStatus(BookingStatus.CANCELLED);
		
		return "Booking cancelled";
		
	}

}
