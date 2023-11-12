package com.imaginnovate.dpe.data.response;

import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
public class ZipSearchResponse {

	Boolean status;

	Boolean isZipQualifier;

	List<ZipSearch> message;

	public ZipSearchResponse(Boolean isZipQualifier, List<ZipSearch> message) {
		super();
		this.status = true;
		this.isZipQualifier = isZipQualifier;
		this.message = message;
	}

}
