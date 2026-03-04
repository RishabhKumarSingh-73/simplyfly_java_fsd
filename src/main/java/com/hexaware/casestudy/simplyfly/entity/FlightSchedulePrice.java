package com.hexaware.casestudy.simplyfly.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class FlightSchedulePrice {
	
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "flight_schedule_id",nullable = false)
	private FlightSchedule flightSchedule;
	
	private String seatClass;
	private double basePrice;
	public FlightSchedulePrice() {
		super();
	}
	public FlightSchedulePrice(int id,String seatClass, double basePrice) {
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
	public String getSeatClass() {
		return seatClass;
	}
	public void setSeatClass(String seatClass) {
		this.seatClass = seatClass;
	}
	public double getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}
	
	
}
