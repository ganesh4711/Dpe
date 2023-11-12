package com.imaginnovate.dpe.data.requests;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class RateRequestMiles {

	@NotNull(message = "Origin radius in miles cannot be empty.")
	@Min(value = 0, message = "Origin radius in miles must be greater than or equal to 0.")
	@Max(value = 200, message = "Origin radius in miles must be less than 200.")
	private Integer originRadius;

	@NotNull(message = "Destination radius in miles cannot be empty.")
	@Min(value = 0, message = "Destination radius in miles must be greater than 0.")
	@Max(value = 200, message = "Destination radius in miles must be less than 200.")
	private Integer destRadius;

	public Integer getDestRadius() {
		return destRadius;
	}

	public Integer getOriginRadius() {
		return originRadius;
	}

	public void setDestRadius(Integer destRadius) {
		this.destRadius = destRadius;
	}

	public void setOriginRadius(Integer originRadius) {
		this.originRadius = originRadius;
	}

}
