package com.imaginnovate.dpe.data.response;

import lombok.Data;

@Data
public class ProviderRateResponse {

	private String providerId;

	private ProviderRateInfo maxPay;

	private ProviderRateInfo targetPay;

	private String errorMessage;

	private  double miles;

	public ProviderRateResponse(ProviderRateInfo maxPay, ProviderRateInfo targetPay, double miles) {
		this.maxPay = maxPay;
		this.targetPay = targetPay;
		this.miles= miles;
	}

}
