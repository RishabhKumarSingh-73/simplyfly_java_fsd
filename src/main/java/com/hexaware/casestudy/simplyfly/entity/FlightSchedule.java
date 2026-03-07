package com.hexaware.casestudy.simplyfly.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.casestudy.simplyfly.enums.FlightScheduleStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class FlightSchedule {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "flight_id",nullable = false)
	private Flight flight;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "route_id",nullable = false)
	private Route route;
	
	private LocalDateTime departureDateTime;
	private LocalDateTime arivalDateTime;
	
	@Enumerated(EnumType.STRING)
	private FlightScheduleStatus status;
	
	@OneToMany(mappedBy = "flightSchedule",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<FlightSchedulePrice> flightSchedulePrices = new ArrayList<>();
	
	@OneToMany(mappedBy = "flightSchedule",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<FlightSeat> flightSeats = new ArrayList<>();
	
	public FlightSchedule() {
		super();
	}

	public FlightSchedule(int id,  LocalDateTime departureDateTime,
			LocalDateTime arivalDateTime, FlightScheduleStatus status) {
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

	public FlightScheduleStatus getStatus() {
		return status;
	}

	public void setStatus(FlightScheduleStatus status) {
		this.status = status;
	}
	
	
	
}
