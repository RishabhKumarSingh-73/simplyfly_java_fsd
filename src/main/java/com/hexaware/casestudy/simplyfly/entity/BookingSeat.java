package com.hexaware.casestudy.simplyfly.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class BookingSeat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "booking_id", nullable = false)
	private Booking booking;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "flight_seat_id", nullable = false)
	private FlightSeat flightSeat;
	
	private double price_paid;
	
	public BookingSeat() {
		super();
	}

	public BookingSeat(int id, double price_paid) {
		super();
		this.id = id;
		this.price_paid = price_paid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public FlightSeat getFlightSeat() {
		return flightSeat;
	}

	public void setFlightSeat(FlightSeat flightSeat) {
		this.flightSeat = flightSeat;
	}

	public double getPrice_paid() {
		return price_paid;
	}

	public void setPrice_paid(double price_paid) {
		this.price_paid = price_paid;
	}
	
	
}
