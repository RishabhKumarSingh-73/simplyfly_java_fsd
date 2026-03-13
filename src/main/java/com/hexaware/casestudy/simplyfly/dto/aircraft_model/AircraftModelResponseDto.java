package com.hexaware.casestudy.simplyfly.dto.aircraft_model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AircraftModelResponseDto {

     private int id;
	 private String modelName;
	 private String manufacturer;
	 private int totalRows;
	 private String layoutDescription;

}

