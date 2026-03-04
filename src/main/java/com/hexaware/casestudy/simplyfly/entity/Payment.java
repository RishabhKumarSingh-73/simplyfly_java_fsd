package com.hexaware.casestudy.simplyfly.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Payment {
	
	  private int id;
	  
	  @ManyToOne(fetch = FetchType.LAZY)
	  @JoinColumn(name = "booking_id",nullable = false)
	  private Booking booking;
	  
	  private String paymentGatewayRef;
	  private String mode;
	  private String status;
	  private double amount;
	  private LocalDateTime paidAt;
	  
	  public Payment() {
		super();
	  }

	  public Payment(int id, String paymentGatewayRef, String mode, String status, double amount,
			LocalDateTime paidAt) {
		super();
		this.id = id;
		this.paymentGatewayRef = paymentGatewayRef;
		this.mode = mode;
		this.status = status;
		this.amount = amount;
		this.paidAt = paidAt;
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

	  public String getPaymentGatewayRef() {
		  return paymentGatewayRef;
	  }

	  public void setPaymentGatewayRef(String paymentGatewayRef) {
		  this.paymentGatewayRef = paymentGatewayRef;
	  }

	  public String getMode() {
		  return mode;
	  }

	  public void setMode(String mode) {
		  this.mode = mode;
	  }

	  public String getStatus() {
		  return status;
	  }

	  public void setStatus(String status) {
		  this.status = status;
	  }

	  public double getAmount() {
		  return amount;
	  }

	  public void setAmount(double amount) {
		  this.amount = amount;
	  }

	  public LocalDateTime getPaidAt() {
		  return paidAt;
	  }

	  public void setPaidAt(LocalDateTime paidAt) {
		  this.paidAt = paidAt;
	  }
	  
	  
}
