package com.hexaware.casestudy.simplyfly.dto;

import com.hexaware.casestudy.simplyfly.enums.SeatClass;

public class FlightSchedulePriceDTO {

	private SeatClass seatClass;
    private double basePrice;

    public FlightSchedulePriceDTO() {}

    public SeatClass getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(SeatClass seatClass) {
        this.seatClass = seatClass;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }

}
