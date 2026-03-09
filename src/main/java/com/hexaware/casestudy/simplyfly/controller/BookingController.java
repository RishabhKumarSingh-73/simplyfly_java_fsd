package com.hexaware.casestudy.simplyfly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.casestudy.simplyfly.entity.Booking;
import com.hexaware.casestudy.simplyfly.enums.BookingStatus;
import com.hexaware.casestudy.simplyfly.exception.BookingNotFoundException;
import com.hexaware.casestudy.simplyfly.service.BookingServiceImp;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingServiceImp service;

    @GetMapping
    public List<Booking> getAllBookings() {
        return service.getAllBookings();
    }

    @GetMapping("/{id}")
    public Booking getBooking(@PathVariable int id) throws BookingNotFoundException {
        return service.getBookingById(id);
    }

    @GetMapping("/user/{userId}")
    public List<Booking> getUserBookings(@PathVariable int userId) {
        return service.getBookingsByUserId(userId);
    }

    @PostMapping
    public Booking addBooking(@RequestBody Booking booking) {
        return service.addBooking(booking);
    }

    @PutMapping("/{id}/{status}")
    public Booking updateStatus(@PathVariable int id,
                                @PathVariable BookingStatus status)
            throws BookingNotFoundException {
        return service.updateBookingStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public String cancelBooking(@PathVariable int id) throws BookingNotFoundException {
        return service.cancelBooking(id);
    }
}
