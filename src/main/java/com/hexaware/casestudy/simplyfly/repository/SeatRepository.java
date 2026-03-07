package com.hexaware.casestudy.simplyfly.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.casestudy.simplyfly.entity.Seat;

public interface SeatRepository extends JpaRepository<Seat, Integer> {

	List<Seat> findByAircraftModel_Id(int aircraftModel_id);
	
}
