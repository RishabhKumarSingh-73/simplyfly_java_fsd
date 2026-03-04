package com.hexaware.casestudy.simplyfly.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Flight {
	
	private int id;
	private String flightNumber;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "owner_id",nullable = false)
	private User owner;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "aircraft_model_id", nullable = false)
	private AircraftModel aircraftModel;
	
	private boolean isActive;
	

	
	public Flight() {
		super();
	}

	public Flight(int id, String flightNumber, boolean isActive) {
		super();
		this.id = id;
		this.flightNumber = flightNumber;
		this.isActive = isActive;
	}
	
	

	public AircraftModel getAircraftModel() {
		return aircraftModel;
	}

	public void setAircraftModel(AircraftModel aircraftModel) {
		this.aircraftModel = aircraftModel;
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

	

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public AircraftModel getAircraftModelId() {
		return aircraftModel;
	}

	public void setAircraftModelId(AircraftModel aircraftModel) {
		this.aircraftModel = aircraftModel;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	
}
