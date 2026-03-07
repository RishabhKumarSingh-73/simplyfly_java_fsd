package com.hexaware.casestudy.simplyfly.service;

import java.util.List;

import com.hexaware.casestudy.simplyfly.entity.BookingSeat;
import com.hexaware.casestudy.simplyfly.exception.BookingSeatNotFoundException;

public interface IBookingSeatService {
	
	List<BookingSeat> getBookingSeatsByBookingId(int bookingId);
	BookingSeat addBookingSeat(BookingSeat bookingSeat);
    String deleteBookingSeatById(int id)throws BookingSeatNotFoundException;
}
