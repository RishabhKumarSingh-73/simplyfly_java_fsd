package com.hexaware.casestudy.simplyfly.entity;

import com.hexaware.casestudy.simplyfly.enums.FlightSeatStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class FlightSeat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "flight_schedule_id",nullable = false)
	private FlightSchedule flightSchedule;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "seat_id",nullable = false)
	private Seat seat;
	
	@Enumerated(EnumType.STRING)
	private FlightSeatStatus status;
	
	public FlightSeat() {
		super();
	}

	public FlightSeat(int id, FlightSeatStatus status) {
		super();
		this.id = id;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public FlightSchedule getFlightSchedule() {
		return flightSchedule;
	}

	public void setFlightSchedule(FlightSchedule flightSchedule) {
		this.flightSchedule = flightSchedule;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public FlightSeatStatus getStatus() {
		return status;
	}

	public void setStatus(FlightSeatStatus status) {
		this.status = status;
	}
	
	
}
