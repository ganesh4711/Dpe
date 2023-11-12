package com.imaginnovate.dpe.data.response;

import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
public class TSRateResult {

	private List<TSRateData> rateEngineResults;
	private Double miles;
	private Double calculatedRateFlat;
	private Double targetRateFlat;
	private Double forecastedRates;
	private Double fuelChargeRateFlat;

	public TSRateResult() {

	}
}
