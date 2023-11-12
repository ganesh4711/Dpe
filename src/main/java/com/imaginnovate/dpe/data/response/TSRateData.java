package com.imaginnovate.dpe.data.response;

import lombok.Data;
import lombok.Getter;

@Data
public class TSRateData {

	private String name;
	private Double flatRate;
	private Integer reports;
	private Double fuelCost;
	private Double rpm;
	private Double allin;
	private Double allinRpm;
	private Double lineHaul;
	private Double lineHaulRpm;
	private Double fuelCostRpm;
	private String includedInCalculatedRate;

	public TSRateData() {

	}
}
