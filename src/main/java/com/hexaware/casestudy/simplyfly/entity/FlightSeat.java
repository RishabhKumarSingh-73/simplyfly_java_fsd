package com.hexaware.casestudy.simplyfly.entity;


public class FlightSeat {
	
	private int id;
	private int flightScheduleId;
	private int seatId;
	private String status;
	
	public FlightSeat() {
		super();
	}

	public FlightSeat(int id, int flightScheduleId, int seatId, String status) {
		super();
		this.id = id;
		this.flightScheduleId = flightScheduleId;
		this.seatId = seatId;
		this.status = status;
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

	public int getSeatId() {
		return seatId;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
