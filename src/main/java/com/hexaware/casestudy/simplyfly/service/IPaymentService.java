package com.hexaware.casestudy.simplyfly.service;

import java.util.List;

import com.hexaware.casestudy.simplyfly.entity.Payment;
import com.hexaware.casestudy.simplyfly.enums.PaymentStatus;
import com.hexaware.casestudy.simplyfly.exception.PaymentNotFoundException;

public interface IPaymentService {
	
	List<Payment> getPaymentsByBookingId(int bookingId);
    Payment getPaymentById(int id) throws PaymentNotFoundException;
    Payment addPayment(Payment payment);
    Payment updatePaymentStatus(int paymentId, PaymentStatus status)throws PaymentNotFoundException;
}
