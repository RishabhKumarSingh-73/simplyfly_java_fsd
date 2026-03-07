package com.hexaware.casestudy.simplyfly.entity;

import java.time.LocalDateTime;

import com.hexaware.casestudy.simplyfly.enums.PaymentMode;
import com.hexaware.casestudy.simplyfly.enums.PaymentStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Payment {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private int id;
	  
	  @ManyToOne(fetch = FetchType.LAZY)
	  @JoinColumn(name = "booking_id",nullable = false)
	  private Booking booking;
	  
	  private String paymentGatewayRef;
	  
	  @Enumerated(EnumType.STRING)
	  private PaymentMode mode;
	  
	  @Enumerated(EnumType.STRING)
	  private PaymentStatus status;
	  
	  private double amount;
	  private LocalDateTime paidAt;
	  
	  public Payment() {
		super();
	  }

	  public Payment(int id, String paymentGatewayRef, PaymentMode mode, PaymentStatus status, double amount,
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

	  public PaymentMode getMode() {
		  return mode;
	  }

	  public void setMode(PaymentMode mode) {
		  this.mode = mode;
	  }

	  public PaymentStatus getStatus() {
		  return status;
	  }

	  public void setStatus(PaymentStatus status) {
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
