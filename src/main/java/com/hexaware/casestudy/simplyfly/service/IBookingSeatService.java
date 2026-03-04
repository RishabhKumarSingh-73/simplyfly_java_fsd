package com.hexaware.casestudy.simplyfly.service;

import java.util.List;

import com.hexaware.casestudy.simplyfly.entity.BookingSeat;

public interface IBookingSeatService {
	
	List<BookingSeat> getBookingSeatsByBookingId(int bookingId);
    int addBookingSeat(BookingSeat bookingSeat);
    int deleteBookingSeatById(int id);
}
