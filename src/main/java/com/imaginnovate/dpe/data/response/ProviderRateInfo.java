package com.imaginnovate.dpe.data.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.imaginnovate.dpe.common.Enums;

public class ProviderRateInfo {

	@JsonIgnore
	public String pid;

	@JsonIgnore
	public Enums.RateType payTypeName;

	public String calType;


	public Double rate;

	public Double ratePerMile;

	@JsonIgnore
	private Double actualRate;

	@JsonIgnore
	private Double actualRatePerMile;

	private Double miles;

	public Double weight;


	public Long duration;


	private String errorMessage;

	private Object metaData;

	public Object getMetaData() {
		return metaData;
	}

	public void setMetaData(Object metaData) {
		this.metaData = metaData;
	}

	public ProviderRateInfo() {

	}

	public Double getActualRate() {
		return actualRate;
	}

	public Double getActualRatePerMile() {
		return actualRatePerMile;
	}

	public String getCalType() {
		return calType;
	}

	public Long getDuration() {
		return duration;
	}

	public Double getMiles() {
		return miles;
	}

	public Enums.RateType getPayTypeName() {
		return payTypeName;
	}

	public String getPid() {
		return pid;
	}

	public Double getRate() {
		return rate;
	}

	public Double getRatePerMile() {
		return ratePerMile;
	}

	public Double getWeight() {
		return weight;
	}

	public void setActualRate(Double actualRate) {
		this.actualRate = actualRate;
	}

	public void setActualRatePerMile(Double actualRatePerMile) {
		this.actualRatePerMile = actualRatePerMile;
	}

	public void setCalType(String calType) {
		this.calType = calType;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public void setMiles(Double miles) {
		this.miles = miles;
	}

	public void setPayTypeName(Enums.RateType payTypeName) {
		this.payTypeName = payTypeName;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public void setRatePerMile(Double ratePerMile) {
		this.ratePerMile = ratePerMile;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

}
