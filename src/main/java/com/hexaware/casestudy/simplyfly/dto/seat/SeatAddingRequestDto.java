package com.hexaware.casestudy.simplyfly.dto.seat;

import com.hexaware.casestudy.simplyfly.enums.SeatClass;
import com.hexaware.casestudy.simplyfly.enums.SeatPosition;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SeatAddingRequestDto {

	@NotNull(message = "aircraft model id cant be null")
	private int aircraftModelId;
	@NotNull(message = "Row Number cant be null")
	private int rowNumber;
	@NotBlank(message = "column Letter id cant be blank")
	private char columnLetter;
	@NotNull(message = "Seat Class cant be null")
	private SeatClass seatClass;
	@NotNull(message = "Seat Position cant be null")
	private SeatPosition positionType;
}
