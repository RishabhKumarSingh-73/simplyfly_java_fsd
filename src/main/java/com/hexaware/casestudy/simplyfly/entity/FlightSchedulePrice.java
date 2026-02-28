package com.hexaware.casestudy.simplyfly.entity;


public class FlightSchedulePrice {
	
	private int id;
	private int flightScheduleId;
	private String seatClass;
	private double basePrice;
	public FlightSchedulePrice() {
		super();
	}
	public FlightSchedulePrice(int id, int flightScheduleId, String seatClass, double basePrice) {
		super();
		this.id = id;
		this.flightScheduleId = flightScheduleId;
		this.seatClass = seatClass;
		this.basePrice = basePrice;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFlightScheduleId() {
		return flightScheduleId;
	}
	public void setFlightScheduleId(int flightScheduleId) {
		this.flightScheduleId = flightScheduleId;
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
