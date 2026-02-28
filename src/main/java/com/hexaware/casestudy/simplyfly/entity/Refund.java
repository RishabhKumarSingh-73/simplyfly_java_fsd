package com.hexaware.casestudy.simplyfly.entity;

import java.time.LocalDateTime;

public class Refund {
	
	private int id;
	private int paymentId;
	private double amount;
	private String status;
	private LocalDateTime refundedAt;
	
	public Refund() {
		super();
	}

	public Refund(int id, int paymentId, double amount, String status, LocalDateTime refundedAt) {
		super();
		this.id = id;
		this.paymentId = paymentId;
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

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
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
