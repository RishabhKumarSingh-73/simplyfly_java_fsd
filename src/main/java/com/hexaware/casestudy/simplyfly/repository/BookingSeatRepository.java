package com.hexaware.casestudy.simplyfly.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.casestudy.simplyfly.entity.BookingSeat;

public interface BookingSeatRepository extends JpaRepository<BookingSeat, Integer> {

	List<BookingSeat> findByBooking_Id(int booking_Id);
	
}
