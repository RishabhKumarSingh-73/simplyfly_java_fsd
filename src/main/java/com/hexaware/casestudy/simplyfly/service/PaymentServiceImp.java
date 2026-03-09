package com.hexaware.casestudy.simplyfly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.casestudy.simplyfly.entity.Payment;
import com.hexaware.casestudy.simplyfly.enums.PaymentStatus;
import com.hexaware.casestudy.simplyfly.exception.PaymentNotFoundException;
import com.hexaware.casestudy.simplyfly.repository.PaymentRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PaymentServiceImp implements IPaymentService {
	
	@Autowired
	private PaymentRepository repository;

	@Override
	public List<Payment> getPaymentsByBookingId(int bookingId) {
		
		return repository.findByBooking_Id(bookingId);
		
	}

	@Override
	public Payment getPaymentById(int id) throws PaymentNotFoundException{
		
		return repository.findById(id).orElseThrow(()->new PaymentNotFoundException("payment not found exception"));
		
	}

	@Override
	public Payment addPayment(Payment payment) {
		
		return repository.save(payment);
		
	}

	@Override
	public Payment updatePaymentStatus(int paymentId, PaymentStatus status) throws PaymentNotFoundException{
		
		Payment payment = repository.findById(paymentId).orElseThrow(()->new PaymentNotFoundException("payment not found exception"));
		
		payment.setStatus(status);
		
		return repository.save(payment);
		
	}

}
