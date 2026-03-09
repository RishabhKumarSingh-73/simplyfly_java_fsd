package com.hexaware.casestudy.simplyfly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hexaware.casestudy.simplyfly.entity.FlightSchedulePrice;
import com.hexaware.casestudy.simplyfly.enums.SeatClass;
import com.hexaware.casestudy.simplyfly.exception.FlightSchedulePriceNotFoundException;
import com.hexaware.casestudy.simplyfly.service.FlightSchedulePriceServiceImp;

@RestController
@RequestMapping("/api/flight-schedule-prices")
public class FlightSchedulePriceController {

    @Autowired
    private FlightSchedulePriceServiceImp service;

    @GetMapping("/schedule/{scheduleId}")
    public List<FlightSchedulePrice> getPricesByScheduleId(@PathVariable int scheduleId) {
        return service.getPricesByScheduleId(scheduleId);
    }

    @GetMapping("/schedule/{scheduleId}/class/{seatClass}")
    public FlightSchedulePrice getPriceByScheduleAndClass(
            @PathVariable int scheduleId,
            @PathVariable SeatClass seatClass)
            throws FlightSchedulePriceNotFoundException {

        return service.getPriceByScheduleAndClass(scheduleId, seatClass);
    }

    @PostMapping
    public FlightSchedulePrice addPrice(@RequestBody FlightSchedulePrice price) {
        return service.addPrice(price);
    }

    @PutMapping
    public FlightSchedulePrice updatePrice(@RequestBody FlightSchedulePrice price)
            throws FlightSchedulePriceNotFoundException {

        return service.updatePrice(price);
    }

    @DeleteMapping("/{id}")
    public String deletePrice(@PathVariable int id)
            throws FlightSchedulePriceNotFoundException {

        return service.deletePriceById(id);
    }
}
