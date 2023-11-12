package com.imaginnovate.dpe.data.requests;


import com.imaginnovate.dpe.data.response.ZipSearchInfo;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class RateRequest extends BaseRateRequest {

	@NotNull(message = "Origin cannot be empty")
	private ZipSearchInfo origin;

	@NotNull(message = "Destination cannot be empty")
	private ZipSearchInfo destination;

	@NotNull(message = "Equipment type cannot be empty")
	private String equipmentType;

    @NotNull
	private List<Long> accessorials;

	private String name;
//
//	@NotNull(message = "Coverage details cannot be empty.")
//	@Valid
//	private RateRequestMiles coverage;

	private Date pickupDate;

	private Date deliveryDate;

	private boolean sameDayPickUp;

	private double miles;

	private Long ruleSetId;

	public RateRequest() {
	}

}
