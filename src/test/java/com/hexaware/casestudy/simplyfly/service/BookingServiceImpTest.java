package com.hexaware.casestudy.simplyfly.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.casestudy.simplyfly.entity.Booking;
import com.hexaware.casestudy.simplyfly.enums.BookingStatus;
import com.hexaware.casestudy.simplyfly.exception.BookingNotFoundException;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
class BookingServiceImpTest {

    @Autowired
    private BookingServiceImp service;

    @Test
    void testAddBooking() {

        Booking booking = new Booking();
        booking.setTotalAmount(5000);
        booking.setStatus(BookingStatus.PENDING);

        Booking saved = service.addBooking(booking);

        assertNotNull(saved);
        assertTrue(saved.getId() > 0);
    }

    @Test
    void testGetAllBookings() {

        Booking booking = new Booking();
        booking.setTotalAmount(6000);
        booking.setStatus(BookingStatus.PENDING);

        service.addBooking(booking);

        List<Booking> list = service.getAllBookings();

        assertNotNull(list);
        assertTrue(list.size() > 0);
    }

    @Test
    void testGetBookingById() throws BookingNotFoundException {

        Booking booking = new Booking();
        booking.setTotalAmount(4500);
        booking.setStatus(BookingStatus.PENDING);

        Booking saved = service.addBooking(booking);

        Booking found = service.getBookingById(saved.getId());

        assertEquals(saved.getId(), found.getId());
    }

    @Test
    void testGetBookingsByUserId() {

        Booking booking = new Booking();
        booking.setTotalAmount(7000);
        booking.setStatus(BookingStatus.PENDING);

        service.addBooking(booking);

        List<Booking> list = service.getBookingsByUserId(1);

        assertNotNull(list);
    }

    @Test
    void testUpdateBookingStatus() throws BookingNotFoundException {

        Booking booking = new Booking();
        booking.setTotalAmount(8000);
        booking.setStatus(BookingStatus.PENDING);

        Booking saved = service.addBooking(booking);

        Booking updated = service.updateBookingStatus(saved.getId(), BookingStatus.CONFIRMED);

        assertEquals(BookingStatus.CONFIRMED, updated.getStatus());
    }

    @Test
    void testCancelBooking() throws BookingNotFoundException {

        Booking booking = new Booking();
        booking.setTotalAmount(5500);
        booking.setStatus(BookingStatus.PENDING);

        Booking saved = service.addBooking(booking);

        String result = service.cancelBooking(saved.getId());

        assertEquals("Booking cancelled", result);
    }
}