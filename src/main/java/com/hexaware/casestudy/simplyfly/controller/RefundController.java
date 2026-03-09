package com.hexaware.casestudy.simplyfly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.casestudy.simplyfly.entity.Refund;
import com.hexaware.casestudy.simplyfly.enums.RefundStatus;
import com.hexaware.casestudy.simplyfly.exception.RefundNotFoundException;
import com.hexaware.casestudy.simplyfly.service.RefundServiceImp;

@RestController
@RequestMapping("/api/refunds")
public class RefundController {

    @Autowired
    private RefundServiceImp service;

    @GetMapping("/payment/{paymentId}")
    public List<Refund> getRefunds(@PathVariable int paymentId) {
        return service.getRefundsByPaymentId(paymentId);
    }

    @GetMapping("/{id}")
    public Refund getRefund(@PathVariable int id) throws RefundNotFoundException {
        return service.getRefundById(id);
    }

    @PostMapping
    public Refund addRefund(@RequestBody Refund refund) {
        return service.addRefund(refund);
    }

    @PutMapping("/{id}/{status}")
    public Refund updateRefundStatus(@PathVariable int id,
                                     @PathVariable RefundStatus status)
            throws RefundNotFoundException {
        return service.updateRefundStatus(id, status);
    }
}
