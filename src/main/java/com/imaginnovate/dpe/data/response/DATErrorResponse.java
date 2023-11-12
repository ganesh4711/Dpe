package com.imaginnovate.dpe.data.response;

import lombok.Data;

import java.util.List;

@Data
public class DATErrorResponse {

	private Integer statusCode;

	private List<DATErrorInfo> errors;

}
