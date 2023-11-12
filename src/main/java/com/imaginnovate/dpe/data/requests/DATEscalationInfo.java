package com.imaginnovate.dpe.data.requests;

import com.fasterxml.jackson.annotation.JsonInclude;

public class DATEscalationInfo {

	private String escalationType;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String specificTimeFrame;

	public DATEscalationInfo() {
		this.escalationType = "SPECIFIC_TIME_FRAME_AND_SMALLEST_AREA_TYPE";
	}

	public void setEscalationType(String escalationType) {
		this.escalationType = escalationType;
	}

	public String getEscalationType() {
		return escalationType;
	}

	public void setSpecificTimeFrame(String specificTimeFrame) {
		this.specificTimeFrame = specificTimeFrame;
	}

	public String getSpecificTimeFrame() {
		return specificTimeFrame;
	}

}
