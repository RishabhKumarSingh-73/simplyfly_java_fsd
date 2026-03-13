package com.hexaware.casestudy.simplyfly.dto.aircraft_model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AircraftModelAddingRequestDto {

	 @NotBlank(message = "model name cant be blank")
	 private String modelName;
	 @NotBlank(message = "model name cant be blank")
	 private String manufacturer;
	 @Min(value = 1)
	 private int totalRows;
	 @NotBlank(message = "model name cant be blank")
	 private String layoutDescription;
	 
}
