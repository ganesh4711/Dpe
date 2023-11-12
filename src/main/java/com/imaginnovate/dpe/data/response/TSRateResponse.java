package com.imaginnovate.dpe.data.response;

import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
public class TSRateResponse {

	private List<TSRateResult> data;
	private Integer statusCode;
	private String message;

	public TSRateResponse() {

	}
}
