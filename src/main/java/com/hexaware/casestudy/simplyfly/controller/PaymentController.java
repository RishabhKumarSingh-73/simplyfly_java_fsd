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

import com.hexaware.casestudy.simplyfly.entity.Payment;
import com.hexaware.casestudy.simplyfly.enums.PaymentStatus;
import com.hexaware.casestudy.simplyfly.exception.PaymentNotFoundException;
import com.hexaware.casestudy.simplyfly.service.PaymentServiceImp;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentServiceImp service;

    @GetMapping("/booking/{bookingId}")
    public List<Payment> getPayments(@PathVariable int bookingId) {
        return service.getPaymentsByBookingId(bookingId);
    }

    @GetMapping("/{id}")
    public Payment getPayment(@PathVariable int id) throws PaymentNotFoundException {
        return service.getPaymentById(id);
    }

    @PostMapping
    public Payment addPayment(@RequestBody Payment payment) {
        return service.addPayment(payment);
    }

    @PutMapping("/{id}/{status}")
    public Payment updatePaymentStatus(@PathVariable int id,
                                       @PathVariable PaymentStatus status)
            throws PaymentNotFoundException {
        return service.updatePaymentStatus(id, status);
    }
}
