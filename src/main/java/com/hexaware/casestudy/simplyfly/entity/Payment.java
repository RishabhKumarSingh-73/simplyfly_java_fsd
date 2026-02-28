package com.hexaware.casestudy.simplyfly.entity;

import java.time.LocalDateTime;

public class Payment {
	
	  private int id;
	  private int bookingId;
	  private String paymentGatewayRef;
	  private String mode;
	  private String status;
	  private double amount;
	  private LocalDateTime paidAt;
	  
	  public Payment() {
		super();
	  }

	  public Payment(int id, int bookingId, String paymentGatewayRef, String mode, String status, double amount,
			LocalDateTime paidAt) {
		super();
		this.id = id;
		this.bookingId = bookingId;
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

	  public int getBookingId() {
		  return bookingId;
	  }

	  public void setBookingId(int bookingId) {
		  this.bookingId = bookingId;
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
