package com.hexaware.casestudy.simplyfly.entity;


import com.hexaware.casestudy.simplyfly.enums.SeatClass;

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
public class FlightSchedulePrice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "flight_schedule_id",nullable = false)
	private FlightSchedule flightSchedule;
	
	@Enumerated(EnumType.STRING)
	private SeatClass seatClass;
	
	private double basePrice;
	public FlightSchedulePrice() {
		super();
	}
	public FlightSchedulePrice(int id,SeatClass seatClass, double basePrice) {
		super();
		this.id = id;
		this.seatClass = seatClass;
		this.basePrice = basePrice;
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
	public SeatClass getSeatClass() {
		return seatClass;
	}
	public void setSeatClass(SeatClass seatClass) {
		this.seatClass = seatClass;
	}
	public double getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}
	
	
}
