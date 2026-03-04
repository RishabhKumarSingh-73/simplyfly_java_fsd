package com.hexaware.casestudy.simplyfly.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Seat {
	
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "aircraft_model_id",nullable = false)
	private AircraftModel aircraftModel;
	
	private int rowNumber;
	private char columnLetter;
	private String seatClass;
	private String positionType;
	
	public Seat() {
		super();
	}

	public Seat(int id, int rowNumber, char columnLetter, String seatClass,
			String positionType) {
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

	public String getSeatClass() {
		return seatClass;
	}

	public void setSeatClass(String seatClass) {
		this.seatClass = seatClass;
	}

	public String getPositionType() {
		return positionType;
	}

	public void setPositionType(String positionType) {
		this.positionType = positionType;
	}
	
	
}
