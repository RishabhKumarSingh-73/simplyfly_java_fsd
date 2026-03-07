package com.hexaware.casestudy.simplyfly.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.casestudy.simplyfly.entity.Refund;

public interface RefundRepository extends JpaRepository<Refund, Integer> {

	List<Refund> findByPayment_Id(int payment_Id);
	
}
