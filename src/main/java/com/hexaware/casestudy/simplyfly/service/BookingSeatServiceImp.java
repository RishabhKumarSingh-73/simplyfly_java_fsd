package com.hexaware.casestudy.simplyfly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.casestudy.simplyfly.entity.BookingSeat;
import com.hexaware.casestudy.simplyfly.exception.BookingSeatNotFoundException;
import com.hexaware.casestudy.simplyfly.repository.BookingSeatRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BookingSeatServiceImp implements IBookingSeatService {
	
	@Autowired
	private BookingSeatRepository repository;

	@Override
	public List<BookingSeat> getBookingSeatsByBookingId(int bookingId) {
		
		return repository.findByBooking_Id(bookingId);
		
	}

	@Override
	public BookingSeat addBookingSeat(BookingSeat bookingSeat) {
		
		return repository.save(bookingSeat);
	}

	@Override
	public String deleteBookingSeatById(int id) throws BookingSeatNotFoundException{
		
		BookingSeat bookingSeat =  repository.findById(id).orElseThrow(()->new BookingSeatNotFoundException("booking seat not found"));
		
		repository.delete(bookingSeat);
		
		return "Booking seat deleted successfully";
	}

}
