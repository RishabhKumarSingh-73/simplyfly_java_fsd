package com.hexaware.casestudy.simplyfly.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.casestudy.simplyfly.entity.FlightSchedule;

public interface FlightScheduleRepository extends JpaRepository<FlightSchedule, Integer> {

}
