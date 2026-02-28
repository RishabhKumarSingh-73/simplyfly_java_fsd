package com.hexaware.casestudy.simplyfly.entity;

public class Flight {
	
	private int id;
	private String flightNumber;
	private int ownerid;
	private int aircraftModelId;
	private boolean isActive;
	
	public Flight() {
		super();
	}

	public Flight(int id, String flightNumber, int ownerid, int aircraftModelId, boolean isActive) {
		super();
		this.id = id;
		this.flightNumber = flightNumber;
		this.ownerid = ownerid;
		this.aircraftModelId = aircraftModelId;
		this.isActive = isActive;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public int getOwnerid() {
		return ownerid;
	}

	public void setOwnerid(int ownerid) {
		this.ownerid = ownerid;
	}

	public int getAircraftModelId() {
		return aircraftModelId;
	}

	public void setAircraftModelId(int aircraftModelId) {
		this.aircraftModelId = aircraftModelId;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	
}
