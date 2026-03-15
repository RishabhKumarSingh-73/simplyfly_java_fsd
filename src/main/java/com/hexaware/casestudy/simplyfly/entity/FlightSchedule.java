package com.hexaware.casestudy.simplyfly.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.casestudy.simplyfly.enums.FlightScheduleStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlightSchedule {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "flight_id",nullable = false)
	private Flight flight;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "route_id",nullable = false)
	private Route route;
	
	private LocalDateTime departureDateTime;
	private LocalDateTime arivalDateTime;
	
	@Enumerated(EnumType.STRING)
	private FlightScheduleStatus status;
	
	@OneToMany(mappedBy = "flightSchedule",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<FlightSchedulePrice> flightSchedulePrices = new ArrayList<>();
	
	@OneToMany(mappedBy = "flightSchedule",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<FlightSeat> flightSeats = new ArrayList<>();
	
	
}
