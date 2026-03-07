package com.hexaware.casestudy.simplyfly.dto;

import java.time.LocalDateTime;
import java.util.List;

public class FlightScheduleCreateDTO {


    private int flightId;
    private int routeId;

    private LocalDateTime departureDatetime;
    private LocalDateTime arrivalDatetime;

    private List<FlightSchedulePriceDTO> prices;

    public FlightScheduleCreateDTO() {}

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public LocalDateTime getDepartureDatetime() {
        return departureDatetime;
    }

    public void setDepartureDatetime(LocalDateTime departureDatetime) {
        this.departureDatetime = departureDatetime;
    }

    public LocalDateTime getArrivalDatetime() {
        return arrivalDatetime;
    }

    public void setArrivalDatetime(LocalDateTime arrivalDatetime) {
        this.arrivalDatetime = arrivalDatetime;
    }

    public List<FlightSchedulePriceDTO> getPrices() {
        return prices;
    }

    public void setPrices(List<FlightSchedulePriceDTO> prices) {
        this.prices = prices;
    }
    
}

