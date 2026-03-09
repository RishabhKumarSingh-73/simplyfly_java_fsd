package com.hexaware.casestudy.simplyfly.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.casestudy.simplyfly.entity.Booking;
import com.hexaware.casestudy.simplyfly.entity.Payment;
import com.hexaware.casestudy.simplyfly.enums.PaymentMode;
import com.hexaware.casestudy.simplyfly.enums.PaymentStatus;
import com.hexaware.casestudy.simplyfly.exception.PaymentNotFoundException;
import com.hexaware.casestudy.simplyfly.repository.PaymentRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
class PaymentServiceImpTest {

    @Autowired
    private PaymentServiceImp service;

    @Autowired
    private PaymentRepository repository;

    private Payment createPaymentRecord() {

        Booking booking = new Booking();
        booking.setId(1);

        Payment payment = new Payment();
        payment.setBooking(booking);
        payment.setAmount(5000);
        payment.setStatus(PaymentStatus.INITIATED);
        payment.setMode(PaymentMode.CARD);

        return repository.save(payment);
    }

    @Test
    void testGetPaymentsByBookingId() {

        createPaymentRecord();

        List<Payment> list = service.getPaymentsByBookingId(1);

        assertNotNull(list);
        assertTrue(list.size() > 0);
    }

    @Test
    void testGetPaymentById() throws PaymentNotFoundException {

        Payment saved = createPaymentRecord();

        Payment payment = service.getPaymentById(saved.getId());

        assertEquals(saved.getId(), payment.getId());
    }

    @Test
    void testAddPayment() {

        Payment saved = createPaymentRecord();

        assertNotNull(saved);
        assertTrue(saved.getId() > 0);
    }

    @Test
    void testUpdatePaymentStatus() throws PaymentNotFoundException {

        Payment saved = createPaymentRecord();

        Payment updated =
                service.updatePaymentStatus(
                        saved.getId(),
                        PaymentStatus.SUCCESS
                );

        assertEquals(PaymentStatus.SUCCESS, updated.getStatus());
    }
}