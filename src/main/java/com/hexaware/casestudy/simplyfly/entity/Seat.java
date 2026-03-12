package com.hexaware.casestudy.simplyfly.entity;

import com.hexaware.casestudy.simplyfly.enums.SeatClass;
import com.hexaware.casestudy.simplyfly.enums.SeatPosition;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Seat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "aircraft_model_id",nullable = false)
	private AircraftModel aircraftModel;
	
	@Column(name = "row_num")
	private int rowNumber;
	private char columnLetter;
	
	@Enumerated(EnumType.STRING)
	private SeatClass seatClass;
	
	@Enumerated(EnumType.STRING)
	private SeatPosition positionType;
	
	public Seat() {
		super();
	}

	public Seat(int id, int rowNumber, char columnLetter, SeatClass seatClass,
			SeatPosition positionType) {
		super();
		this.id = id;
		this.rowNumber = rowNumber;
		this.columnLetter = columnLetter;
		this.seatClass = seatClass;
		this.positionType = positionType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public AircraftModel getAircraftModel() {
		return aircraftModel;
	}

	public void setAircraftModel(AircraftModel aircraftModel) {
		this.aircraftModel = aircraftModel;
	}

	public int getRowNumber() {
		return rowNumber;
	}

	public void setRowNumber(int rowNumber) {
		this.rowNumber = rowNumber;
	}

	public char getColumnLetter() {
		return columnLetter;
	}

	public void setColumnLetter(char columnLetter) {
		this.columnLetter = columnLetter;
	}

	public SeatClass getSeatClass() {
		return seatClass;
	}

	public void setSeatClass(SeatClass seatClass) {
		this.seatClass = seatClass;
	}

	public SeatPosition getPositionType() {
		return positionType;
	}

	public void setPositionType(SeatPosition positionType) {
		this.positionType = positionType;
	}
	
	
}
