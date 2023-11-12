package com.imaginnovate.dpe.data.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class GenericRateResponse implements Serializable {

	/**
	 *
	 */
	static final long serialVersionUID = 3242795213374847744L;

	private Double maxRate;

	private Double minRate;

	private Double rate;

	private String description;

	private Double duration;

	private Double mileage;

	private String  message;


	private  Object metaData;


	public GenericRateResponse(Double maxRate, Double minRate, Double rate, String description, Double duration) {
		this.maxRate = maxRate;
		this.minRate = minRate;
		this.rate = rate;
		this.description = description;
		this.duration = duration;
		this.mileage = 0.0;
	}

	public GenericRateResponse(Double maxRate, Double minRate, Double rate, String description, Double duration,
                               Double mileage) {
		super();
		this.maxRate = maxRate;
		this.minRate = minRate;
		this.rate = rate;
		this.description = description;
		this.duration = duration;
		this.mileage = mileage;
	}	public GenericRateResponse(Double maxRate, Double minRate, Double rate, String description, Double duration,
                                    Double mileage, Object metaData) {
		this.maxRate = maxRate;
		this.minRate = minRate;
		this.rate = rate;
		this.description = description;
		this.duration = duration;
		this.mileage = mileage;
		this.metaData =metaData;
	}

	public GenericRateResponse(Double maxRate, Double minRate, Double rate, String description, Double duration,
							Object metaData) {
		this.maxRate = maxRate;
		this.minRate = minRate;
		this.rate = rate;
		this.description = description;
		this.duration = duration;
		this.mileage = 0.0;
		this.metaData =metaData;
	}

	public void setMaxRate(Double maxRate) {
		if (maxRate != null)
			this.maxRate = maxRate;
	}


	public void setMinRate(Double minRate) {
		if (minRate != null)
			this.minRate = minRate;
	}

	public void setRate(Double rate) {
		if (rate != null)
			this.rate = rate;
	}


	@Override
	public String toString() {
		return String.format("{ minRate : %f, maxRate :%f, rate : %f}", this.minRate, this.maxRate, this.rate);
	}

}
