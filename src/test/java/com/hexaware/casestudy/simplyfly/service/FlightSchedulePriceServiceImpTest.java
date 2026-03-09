package com.hexaware.casestudy.simplyfly.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.casestudy.simplyfly.entity.FlightSchedule;
import com.hexaware.casestudy.simplyfly.entity.FlightSchedulePrice;
import com.hexaware.casestudy.simplyfly.enums.SeatClass;
import com.hexaware.casestudy.simplyfly.exception.FlightSchedulePriceNotFoundException;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
class FlightSchedulePriceServiceImpTest {

    @Autowired
    private FlightSchedulePriceServiceImp service;

    @Test
    void testAddPrice() {

        FlightSchedule schedule = new FlightSchedule();
        schedule.setId(1);

        FlightSchedulePrice price = new FlightSchedulePrice();
        price.setFlightSchedule(schedule);
        price.setSeatClass(SeatClass.ECONOMY);
        price.setBasePrice(4500);

        FlightSchedulePrice saved = service.addPrice(price);

        assertNotNull(saved);
        assertTrue(saved.getId() > 0);
    }

    @Test
    void testGetPricesByScheduleId() {

        FlightSchedule schedule = new FlightSchedule();
        schedule.setId(1);

        FlightSchedulePrice price = new FlightSchedulePrice();
        price.setFlightSchedule(schedule);
        price.setSeatClass(SeatClass.BUSINESS);
        price.setBasePrice(8000);

        service.addPrice(price);

        List<FlightSchedulePrice> list = service.getPricesByScheduleId(1);

        assertNotNull(list);
        assertTrue(list.size() > 0);
    }

    @Test
    void testGetPriceByScheduleAndClass() throws FlightSchedulePriceNotFoundException {

        FlightSchedule schedule = new FlightSchedule();
        schedule.setId(1);

        FlightSchedulePrice price = new FlightSchedulePrice();
        price.setFlightSchedule(schedule);
        price.setSeatClass(SeatClass.ECONOMY);
        price.setBasePrice(5000);

        service.addPrice(price);

        FlightSchedulePrice found = service.getPriceByScheduleAndClass(1, SeatClass.ECONOMY);

        assertEquals(SeatClass.ECONOMY, found.getSeatClass());
    }

    @Test
    void testUpdatePrice() throws FlightSchedulePriceNotFoundException {

        FlightSchedule schedule = new FlightSchedule();
        schedule.setId(1);

        FlightSchedulePrice price = new FlightSchedulePrice();
        price.setFlightSchedule(schedule);
        price.setSeatClass(SeatClass.BUSINESS);
        price.setBasePrice(9000);

        FlightSchedulePrice saved = service.addPrice(price);

        saved.setBasePrice(9500);

        FlightSchedulePrice updated = service.updatePrice(saved);

        assertEquals(9500, updated.getBasePrice());
    }

    @Test
    void testDeletePriceById() throws FlightSchedulePriceNotFoundException {

        FlightSchedule schedule = new FlightSchedule();
        schedule.setId(1);

        FlightSchedulePrice price = new FlightSchedulePrice();
        price.setFlightSchedule(schedule);
        price.setSeatClass(SeatClass.ECONOMY);
        price.setBasePrice(6000);

        FlightSchedulePrice saved = service.addPrice(price);

        String result = service.deletePriceById(saved.getId());

        assertEquals("flight schedule price deleted successfully", result);
    }
}