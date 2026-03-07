package com.hexaware.casestudy.simplyfly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.casestudy.simplyfly.entity.Refund;
import com.hexaware.casestudy.simplyfly.enums.RefundStatus;
import com.hexaware.casestudy.simplyfly.exception.RefundNotFoundException;
import com.hexaware.casestudy.simplyfly.repository.RefundRepository;

@Service
public class RefundServiceImp implements IRefundService {
	
	@Autowired
	private RefundRepository repository;

	@Override
	public List<Refund> getRefundsByPaymentId(int paymentId) {
		
		return repository.findByPayment_Id(paymentId);
		
	}

	@Override
	public Refund getRefundById(int id) throws RefundNotFoundException{
		
		return repository.findById(id).orElseThrow(()->new RefundNotFoundException("refund not found"));
		
	}

	@Override
	public Refund addRefund(Refund refund) {
		
		return repository.save(refund);
		
	}

	@Override
	public Refund updateRefundStatus(int refundId, RefundStatus status) throws RefundNotFoundException{
		
		Refund refund = repository.findById(refundId).orElseThrow(()->new RefundNotFoundException("refund not found"));
		
		refund.setStatus(status);
		
		return repository.save(refund);
		
	}

}
