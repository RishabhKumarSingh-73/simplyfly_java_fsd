package com.hexaware.casestudy.simplyfly.entity;

public class Route {
	
	private int id;
	private String sourceAirportCode;
	private String destinationAirportCode;
	private String sourceCity;
	private String destinationCity;
	
	public Route() {
		super();
	}

	public Route(int id, String sourceAirportCode, String destinationAirportCode, String sourceCity,
			String destinationCity) {
		super();
		this.id = id;
		this.sourceAirportCode = sourceAirportCode;
		this.destinationAirportCode = destinationAirportCode;
		this.sourceCity = sourceCity;
		this.destinationCity = destinationCity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSourceAirportCode() {
		return sourceAirportCode;
	}

	public void setSourceAirportCode(String sourceAirportCode) {
		this.sourceAirportCode = sourceAirportCode;
	}

	public String getDestinationAirportCode() {
		return destinationAirportCode;
	}

	public void setDestinationAirportCode(String destinationAirportCode) {
		this.destinationAirportCode = destinationAirportCode;
	}

	public String getSourceCity() {
		return sourceCity;
	}

	public void setSourceCity(String sourceCity) {
		this.sourceCity = sourceCity;
	}

	public String getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}
	
	
}
