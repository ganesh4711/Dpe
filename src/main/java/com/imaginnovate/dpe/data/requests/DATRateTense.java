package com.imaginnovate.dpe.data.requests;

public class DATRateTense {

	private String rateTense;

	public DATRateTense() {
		this.rateTense = "CURRENT";
	}

	public DATRateTense(String rateTense) {
		this.rateTense = rateTense;
	}

	public String getRateTense() {
		return rateTense;
	}

}
