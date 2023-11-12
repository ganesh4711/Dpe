package com.imaginnovate.dpe.data.response;

import lombok.Data;
import lombok.Getter;

@Data
public class DATRateMileDTO {

	private Double rateUsd;

	private Double highUsd;

	private Double lowUsd;

	public DATRateMileDTO(Double rateUsd, Double highUsd, Double lowUsd) {
		this.rateUsd = rateUsd;
		this.highUsd = highUsd;
		this.lowUsd = lowUsd;
	}

}
