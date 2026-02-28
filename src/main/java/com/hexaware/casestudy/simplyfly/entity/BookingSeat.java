package com.hexaware.casestudy.simplyfly.entity;

public class BookingSeat {
	
	private int id;
	private int bookingId;
	private int flightSeatId;
	private double price_paid;
	
	public BookingSeat() {
		super();
	}

	public BookingSeat(int id, int bookingId, int flightSeatId, double price_paid) {
		super();
		this.id = id;
		this.bookingId = bookingId;
		this.flightSeatId = flightSeatId;
		this.price_paid = price_paid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getFlightSeatId() {
		return flightSeatId;
	}

	public void setFlightSeatId(int flightSeatId) {
		this.flightSeatId = flightSeatId;
	}

	public double getPrice_paid() {
		return price_paid;
	}

	public void setPrice_paid(double price_paid) {
		this.price_paid = price_paid;
	}
	
	
}
