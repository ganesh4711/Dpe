package com.imaginnovate.dpe.data.requests;

import com.fasterxml.jackson.annotation.JsonInclude;

public class DATAreaInfo {

	@JsonInclude(value = JsonInclude.Include.NON_NULL)
	private String postalCode;

	@JsonInclude(value = JsonInclude.Include.NON_NULL)
	private String stateOrProvince;

	@JsonInclude(value = JsonInclude.Include.NON_NULL)
	private String city;

	private String country = "USA";

	public DATAreaInfo() {

	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public String getStateOrProvince() {
		return stateOrProvince;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public void setStateOrProvince(String stateOrProvince) {
		this.stateOrProvince = stateOrProvince;
	}

}
