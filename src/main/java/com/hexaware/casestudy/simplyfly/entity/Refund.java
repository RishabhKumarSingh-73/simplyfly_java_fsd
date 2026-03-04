package com.hexaware.casestudy.simplyfly.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Refund {
	
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "payment_id",nullable = false)
	private Payment payment;
	
	private double amount;
	private String status;
	private LocalDateTime refundedAt;
	
	public Refund() {
		super();
	}

	public Refund(int id, double amount, String status, LocalDateTime refundedAt) {
		super();
		this.id = id;
		this.amount = amount;
		this.status = status;
		this.refundedAt = refundedAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getRefundedAt() {
		return refundedAt;
	}

	public void setRefundedAt(LocalDateTime refundedAt) {
		this.refundedAt = refundedAt;
	}
	
	
}
