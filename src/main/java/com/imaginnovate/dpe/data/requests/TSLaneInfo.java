package com.imaginnovate.dpe.data.requests;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class TSLaneInfo {

	private String typeOfEquipments;
	private String equipmentGroup;
	private String mode;
	private String laneNumber;
	private String targetRate;
	private Double miles;
	private String originCity;
	private String originState;
	private String originCountry;
	private String originZip;
	private String destinationCity;
	private String destinationState;
	private String destinationCountry;
	private String destinationZip;
	private String commodityName;
	private String rateType;

	public TSLaneInfo() {

	}

	public String getCommodityName() {
		return commodityName;
	}

	public String getDestinationCity() {
		return destinationCity;
	}

	public String getDestinationCountry() {
		return destinationCountry;
	}

	public String getDestinationState() {
		return destinationState;
	}

	public String getDestinationZip() {
		return destinationZip;
	}

	public String getEquipmentGroup() {
		return equipmentGroup;
	}

	public String getLaneNumber() {
		return laneNumber;
	}

	public Double getMiles() {
		return miles;
	}

	public String getMode() {
		return mode;
	}

	public String getOriginCity() {
		return originCity;
	}

	public String getOriginCountry() {
		return originCountry;
	}

	public String getOriginState() {
		return originState;
	}

	public String getOriginZip() {
		return originZip;
	}

	public String getRateType() {
		return rateType;
	}

	public String getTargetRate() {
		return targetRate;
	}

	public String getTypeOfEquipments() {
		return typeOfEquipments;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}

	public void setDestinationCountry(String destinationCountry) {
		this.destinationCountry = destinationCountry;
	}

	public void setDestinationState(String destinationState) {
		this.destinationState = destinationState;
	}

	public void setDestinationZip(String destinationZip) {
		this.destinationZip = destinationZip;
	}

	public void setEquipmentGroup(String equipmentGroup) {
		this.equipmentGroup = equipmentGroup;
	}

	public void setLaneNumber(String laneNumber) {
		this.laneNumber = laneNumber;
	}

	public void setMiles(Double miles) {
		this.miles = miles;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public void setOriginCity(String originCity) {
		this.originCity = originCity;
	}

	public void setOriginCountry(String originCountry) {
		this.originCountry = originCountry;
	}

	public void setOriginState(String originState) {
		this.originState = originState;
	}

	public void setOriginZip(String originZip) {
		this.originZip = originZip;
	}

	public void setRateType(String rateType) {
		this.rateType = rateType;
	}

	public void setTargetRate(String targetRate) {
		this.targetRate = targetRate;
	}

	public void setTypeOfEquipments(String typeOfEquipments) {
		this.typeOfEquipments = typeOfEquipments;
	}
	@JsonIgnore
	public String[] getCSVFields() {
		String[] result = {
			this.originCity != null ? this.originCity : "",
			this.originState != null ? this.originState : "",
			this.originZip != null ? this.originZip : "",
			this.destinationCity != null ? this.destinationCity : "",
			this.destinationState != null ? this.destinationState : "",
			this.destinationZip != null ? this.destinationZip : "",
			this.mode != null ? this.mode : "",
			this.equipmentGroup != null ? this.equipmentGroup : "",
			this.miles != null ? String.valueOf(this.miles) : "",
			this.commodityName != null ? this.commodityName : "",
			this.laneNumber != null ?  this.laneNumber : "",
			this.rateType != null ? this.rateType : "",
		};
		return result;
	}
}
