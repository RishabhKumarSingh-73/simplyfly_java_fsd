package com.hexaware.casestudy.simplyfly.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.casestudy.simplyfly.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
