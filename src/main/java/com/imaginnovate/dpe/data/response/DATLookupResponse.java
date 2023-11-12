package com.imaginnovate.dpe.data.response;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class DATLookupResponse {

	private String transaction;

	private Date created;

	private List<DATRateResponses> rateResponses;

}
