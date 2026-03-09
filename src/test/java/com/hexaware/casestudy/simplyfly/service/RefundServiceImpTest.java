package com.hexaware.casestudy.simplyfly.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.casestudy.simplyfly.entity.Payment;
import com.hexaware.casestudy.simplyfly.entity.Refund;
import com.hexaware.casestudy.simplyfly.enums.RefundStatus;
import com.hexaware.casestudy.simplyfly.exception.RefundNotFoundException;
import com.hexaware.casestudy.simplyfly.repository.RefundRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
class RefundServiceImpTest {

    @Autowired
    private RefundServiceImp service;

    @Autowired
    private RefundRepository repository;

    private Refund createRefundRecord() {

        Payment payment = new Payment();
        payment.setId(1);

        Refund refund = new Refund();
        refund.setPayment(payment);
        refund.setAmount(2000);
        refund.setStatus(RefundStatus.REQUESTED);

        return repository.save(refund);
    }

    @Test
    void testGetRefundsByPaymentId() {

        createRefundRecord();

        List<Refund> list = service.getRefundsByPaymentId(1);

        assertNotNull(list);
        assertTrue(list.size() > 0);
    }

    @Test
    void testGetRefundById() throws RefundNotFoundException {

        Refund saved = createRefundRecord();

        Refund refund = service.getRefundById(saved.getId());

        assertEquals(saved.getId(), refund.getId());
    }

    @Test
    void testAddRefund() {

        Refund saved = createRefundRecord();

        assertNotNull(saved);
        assertTrue(saved.getId() > 0);
    }

    @Test
    void testUpdateRefundStatus() throws RefundNotFoundException {

        Refund saved = createRefundRecord();

        Refund updated =
                service.updateRefundStatus(
                        saved.getId(),
                        RefundStatus.PROCESSED
                );

        assertEquals(RefundStatus.PROCESSED, updated.getStatus());
    }
}