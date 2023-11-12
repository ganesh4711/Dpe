package com.imaginnovate.dpe.data.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class SonarRateRequest implements Serializable {

	/**
	 *
	 */
	static final long serialVersionUID = -9051539136766134094L;

	private String origin;

	private String destination;

	private String equipment_type;

	public SonarRateRequest() {

	}

	public SonarRateRequest(String o, String d, String et) {
		this.origin = o;
		this.destination = d;
		this.equipment_type = et;
	}
}
