package com.hexaware.casestudy.simplyfly.service;

import java.util.List;

import com.hexaware.casestudy.simplyfly.entity.Refund;

public interface IRefundService {
	
	List<Refund> getRefundsByPaymentId(int paymentId);
    Refund getRefundById(int id);
    int addRefund(Refund refund);
    int updateRefundStatus(int refundId, String status);
}
