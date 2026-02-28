package com.hexaware.casestudy.simplyfly.entity;

import java.time.LocalDateTime;

public class FlightSchedule {
	
	
	
	private int id;
	private int flightId;
	private int routeId;
	private LocalDateTime departureDateTime;
	private LocalDateTime arivalDateTime;
	private String status;
	
	public FlightSchedule() {
		super();
	}

	public FlightSchedule(int id, int flightId, int routeId, LocalDateTime departureDateTime,
			LocalDateTime arivalDateTime, String status) {
		super();
		this.id = id;
		this.flightId = flightId;
		this.routeId = routeId;
		this.departureDateTime = departureDateTime;
		this.arivalDateTime = arivalDateTime;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public LocalDateTime getDepartureDateTime() {
		return departureDateTime;
	}

	public void setDepartureDateTime(LocalDateTime departureDateTime) {
		this.departureDateTime = departureDateTime;
	}

	public LocalDateTime getArivalDateTime() {
		return arivalDateTime;
	}

	public void setArivalDateTime(LocalDateTime arivalDateTime) {
		this.arivalDateTime = arivalDateTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
