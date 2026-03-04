package com.hexaware.casestudy.simplyfly.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.casestudy.simplyfly.entity.Seat;

public interface SeatRepository extends JpaRepository<Seat, Integer> {

}
