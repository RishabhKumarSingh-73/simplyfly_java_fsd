package com.hexaware.casestudy.simplyfly.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.casestudy.simplyfly.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

	List<Payment> findByBooking_Id(int booking_Id);
	
}
