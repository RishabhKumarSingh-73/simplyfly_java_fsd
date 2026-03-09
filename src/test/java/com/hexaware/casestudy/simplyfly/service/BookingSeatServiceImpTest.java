package com.hexaware.casestudy.simplyfly.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.casestudy.simplyfly.entity.Booking;
import com.hexaware.casestudy.simplyfly.entity.BookingSeat;
import com.hexaware.casestudy.simplyfly.entity.FlightSeat;
import com.hexaware.casestudy.simplyfly.exception.BookingSeatNotFoundException;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
class BookingSeatServiceImpTest {

    @Autowired
    private BookingSeatServiceImp service;

    @Test
    void testAddBookingSeat() {

        BookingSeat seat = new BookingSeat();

        seat.setPrice_paid(5000);

        BookingSeat saved = service.addBookingSeat(seat);

        assertNotNull(saved);
        assertTrue(saved.getId() > 0);
    }

    @Test
    void testGetBookingSeatsByBookingId() {

        Booking booking = new Booking();
        booking.setId(1);

        FlightSeat flightSeat = new FlightSeat();
        flightSeat.setId(1);

        BookingSeat seat = new BookingSeat();
        seat.setBooking(booking);
        seat.setFlightSeat(flightSeat);
        seat.setPrice_paid(4500);

        service.addBookingSeat(seat);

        List<BookingSeat> list = service.getBookingSeatsByBookingId(1);

        assertNotNull(list);
    }

    @Test
    void testDeleteBookingSeatById() throws BookingSeatNotFoundException {

        BookingSeat seat = new BookingSeat();
        seat.setPrice_paid(4000);

        BookingSeat saved = service.addBookingSeat(seat);

        String result = service.deleteBookingSeatById(saved.getId());

        assertEquals("Booking seat deleted successfully", result);
    }
}