package com.hexaware.casestudy.simplyfly.service;

import java.util.List;

import com.hexaware.casestudy.simplyfly.entity.Payment;

public interface IPaymentService {
	
	List<Payment> getPaymentsByBookingId(int bookingId);
    Payment getPaymentById(int id);
    int addPayment(Payment payment);
    int updatePaymentStatus(int paymentId, String status);
}
