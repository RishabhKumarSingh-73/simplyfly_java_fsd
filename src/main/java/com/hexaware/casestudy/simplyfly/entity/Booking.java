package com.hexaware.casestudy.simplyfly.entity;


public class Booking {
	
	
	private int id;
	private int userId;
	private String status;
	private double totalAmount;
	
	public Booking() {
		super();
	}

	public Booking(int id, int userId, String status, double totalAmount) {
		super();
		this.id = id;
		this.userId = userId;
		this.status = status;
		this.totalAmount = totalAmount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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
