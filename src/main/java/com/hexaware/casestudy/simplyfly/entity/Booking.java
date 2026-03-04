package com.hexaware.casestudy.simplyfly.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Booking {
	
	
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id",nullable = false)
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id",nullable = false)
	private FlightSchedule flightSchedule;
	
	private String status;
	private double totalAmount;
	
	@OneToMany(mappedBy = "booking",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<BookingSeat> bookedSeats;
	
	public Booking() {
		super();
	}

	public Booking(int id, String status, double totalAmount) {
		super();
		this.id = id;
		this.status = status;
		this.totalAmount = totalAmount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public List<BookingSeat> getBookedSeats() {
		return bookedSeats;
	}

	public void setBookedSeats(List<BookingSeat> bookedSeats) {
		this.bookedSeats = bookedSeats;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public FlightSchedule getFlightSchedule() {
		return flightSchedule;
	}

	public void setFlightSchedule(FlightSchedule flightSchedule) {
		this.flightSchedule = flightSchedule;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	

}
