package com.imaginnovate.dpe.data.response;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class RateResponseDTO {

	private RateTypeRateInfo baseRateMaxRate;

	private RateTypeRateInfo baseRateTargetRate;

	private RateTypeRateInfo primaryRateMaxRate;

	private RateTypeRateInfo primaryRateTargetRate;

	private RateTypeRateInfo sameDayPickUpMaxRate;

	private RateTypeRateInfo sameDayPickUpTargetRate;

	private RateTypeRateInfo calendarAdjustmentDateMaxRate;

	private RateTypeRateInfo calendarAdjustmentDateTargetRate;

	private RateTypeRateInfo calendarAdjustmentDayMaxRate;

	private RateTypeRateInfo calendarAdjustmentDayTargetRate;

	private RateTypeRateInfo finalMaxRate;

	private RateTypeRateInfo finalTargetRate;

	private String errorMessage;

	private RateTypeRateInfo shipperSellPriceMaxRate;

	private RateTypeRateInfo shipperSellPriceTargetRate;

	private RateTypeRateInfo accessorialMaxRate;

	private RateTypeRateInfo accessorialTargetRate;

	private String accessorialStstusMessage;

	private List<ProviderRateResponse> providerInfo;

	private Date latestRefreshDate;

	private ZipSearchInfo origin;

	private ZipSearchInfo destination;

	private String equipmentType;

	public RateResponseDTO() {

	}

	public RateResponseDTO(RateTypeRateInfo maxRate, RateTypeRateInfo targetRate) {
		super();
		this.baseRateMaxRate = maxRate;
		this.baseRateTargetRate = targetRate;

	}

	public void setPrimaryConfigurationRateInfo(PrimaryConfigurationRateInfo primaryConfigurationRateInfo) {
		this.primaryRateMaxRate = primaryConfigurationRateInfo.getPrimaryRateMaxRate();
		this.primaryRateTargetRate = primaryConfigurationRateInfo.getPrimaryRateTargetRate();
	}

	public void setCalendarAdjustmentDateRateInfo(CalendarAdjustmentDateRateInfo calendarAdjustmentDateRateInfo) {
		this.calendarAdjustmentDateMaxRate = calendarAdjustmentDateRateInfo.getCalendarAdjustmentDateMaxRate();
		this.calendarAdjustmentDateTargetRate = calendarAdjustmentDateRateInfo.getCalendarAdjustmentDateTargetRate();
	}
	public void setCalendarAdjustmentDayRateInfo(CalendarAdjustmentDayRateInfo calendarAdjustmentDayRateInfo) {
		this.calendarAdjustmentDayMaxRate = calendarAdjustmentDayRateInfo.getCalendarAdjustmentDayMaxRate();
		this.calendarAdjustmentDayTargetRate = calendarAdjustmentDayRateInfo.getCalendarAdjustmentDayTargetRate();
	}

	public void setSameDayAdjustmentRateInfo(SameDayPickUpRateInfo sameDayPickUpRateInfo) {
		this.sameDayPickUpMaxRate = sameDayPickUpRateInfo.getSameDayPickUpAdjustmentMaxRate();
		this.sameDayPickUpTargetRate = sameDayPickUpRateInfo.getSameDayPickUpAdjustmentTargetRate();
	}

	public void setFinalConstrantRateInfo(FinalConstrantRateInfo primaryConfigurationRateInfo) {
		this.finalMaxRate = primaryConfigurationRateInfo.getFinalMaxRate();
		this.finalTargetRate = primaryConfigurationRateInfo.getFinalTargetRate();
	}

	public void setShipperSellPriceRateInfo(ShipperSellPriceRateInfo shipperSellPriceRateInfo) {
		this.shipperSellPriceMaxRate = shipperSellPriceRateInfo.getShipperSellRateMaxRate();
		this.shipperSellPriceTargetRate = shipperSellPriceRateInfo.getShipperSellRateTargetRate();
	}

	public void setAccessorialRateInfo(AccessorialRateInfo accessorialRateInfo){
		this.accessorialMaxRate=accessorialRateInfo.getAccessorialMaxRate();
		this.accessorialTargetRate=accessorialRateInfo.getAccessorialTargetRate();
	}
}
