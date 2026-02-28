package com.hexaware.casestudy.simplyfly.entity;


public class Seat {
	
	private int id;
	private int aircraft_model_id;
	private int rowNumber;
	private char columnLetter;
	private String seatClass;
	private String positionType;
	
	public Seat() {
		super();
	}

	public Seat(int id, int aircraft_model_id, int rowNumber, char columnLetter, String seatClass,
			String positionType) {
		super();
		this.id = id;
		this.aircraft_model_id = aircraft_model_id;
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

	public int getAircraft_model_id() {
		return aircraft_model_id;
	}

	public void setAircraft_model_id(int aircraft_model_id) {
		this.aircraft_model_id = aircraft_model_id;
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
