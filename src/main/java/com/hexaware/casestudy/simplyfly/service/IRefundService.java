package com.hexaware.casestudy.simplyfly.service;

import java.util.List;

import com.hexaware.casestudy.simplyfly.entity.Refund;
import com.hexaware.casestudy.simplyfly.enums.RefundStatus;
import com.hexaware.casestudy.simplyfly.exception.RefundNotFoundException;

public interface IRefundService {
	
	List<Refund> getRefundsByPaymentId(int paymentId);
    Refund getRefundById(int id)throws RefundNotFoundException;
    Refund addRefund(Refund refund);
    Refund updateRefundStatus(int refundId, RefundStatus status)throws RefundNotFoundException;
}
