package com.hexaware.casestudy.simplyfly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.casestudy.simplyfly.entity.BookingSeat;
import com.hexaware.casestudy.simplyfly.exception.BookingSeatNotFoundException;
import com.hexaware.casestudy.simplyfly.service.BookingSeatServiceImp;

@RestController
@RequestMapping("/api/booking-seats")
public class BookingSeatController {

    @Autowired
    private BookingSeatServiceImp service;

    @GetMapping("/booking/{bookingId}")
    public List<BookingSeat> getBookingSeats(@PathVariable int bookingId) {
        return service.getBookingSeatsByBookingId(bookingId);
    }

    @PostMapping
    public BookingSeat addBookingSeat(@RequestBody BookingSeat seat) {
        return service.addBookingSeat(seat);
    }

    @DeleteMapping("/{id}")
    public String deleteBookingSeat(@PathVariable int id) throws BookingSeatNotFoundException {
        return service.deleteBookingSeatById(id);
    }
}
