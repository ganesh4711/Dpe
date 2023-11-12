package com.imaginnovate.dpe.data.response;

import lombok.Data;

@Data
public class DATRateDTO {

	private Double mileage;

	private Double reports;

	private Double companies;

	private Double standardDeviation;

	private Double averageFuelSurchargePerMileUsd;

	private Double averageFuelSurchargePerTripUsd;

	private DATRateMileDTO perMile;

	private DATRateMileDTO perTrip;

}
