package com.hexaware.casestudy.simplyfly.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.casestudy.simplyfly.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

	List<Booking> findByUser_Id(int user_Id);
	
}
