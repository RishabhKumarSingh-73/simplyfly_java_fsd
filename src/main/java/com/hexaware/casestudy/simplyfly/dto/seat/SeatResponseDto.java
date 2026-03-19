package com.hexaware.casestudy.simplyfly.dto.seat;

import com.hexaware.casestudy.simplyfly.enums.SeatClass;
import com.hexaware.casestudy.simplyfly.enums.SeatPosition;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SeatResponseDto {

	private int id;
	private int aircraftModelId;
	private int rowNumber;
	private char columnLetter;
	private SeatClass seatClass;
	private SeatPosition positionType;

}
