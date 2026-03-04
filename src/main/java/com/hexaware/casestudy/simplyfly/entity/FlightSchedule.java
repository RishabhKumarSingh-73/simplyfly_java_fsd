package com.hexaware.casestudy.simplyfly.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class FlightSchedule {
	
	
	
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "flight_id",nullable = false)
	private Flight flight;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "route_id",nullable = false)
	private Route route;
	
	private LocalDateTime departureDateTime;
	private LocalDateTime arivalDateTime;
	private String status;
	
	@OneToMany(mappedBy = "flightSchedule",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<FlightSchedulePrice> flightSchedulePrices;
	
	@OneToMany(mappedBy = "flightSchedule",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<FlightSeat> flightSeats;
	
	public FlightSchedule() {
		super();
	}

	public FlightSchedule(int id,  LocalDateTime departureDateTime,
			LocalDateTime arivalDateTime, String status) {
		super();
		this.id = id;
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

	
	
	

	public List<FlightSeat> getFlightSeats() {
		return flightSeats;
	}

	public void setFlightSeats(List<FlightSeat> flightSeats) {
		this.flightSeats = flightSeats;
	}

	public List<FlightSchedulePrice> getFlightSchedulePrices() {
		return flightSchedulePrices;
	}

	public void setFlightSchedulePrices(List<FlightSchedulePrice> flightSchedulePrices) {
		this.flightSchedulePrices = flightSchedulePrices;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
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
