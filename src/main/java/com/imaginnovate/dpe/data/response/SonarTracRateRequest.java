package com.imaginnovate.dpe.data.response;

import lombok.Data;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;


@Data
public class SonarTracRateRequest implements Serializable {

	private String startDate;

	private String endDate;

	private List<SonarRateRequest> lanes;

	public SonarTracRateRequest(String startDate, String endDate, List<SonarRateRequest> lanes) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.lanes = lanes;
	}
}
