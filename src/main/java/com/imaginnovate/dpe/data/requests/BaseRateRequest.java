package com.imaginnovate.dpe.data.requests;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.imaginnovate.dpe.entities.GeoCityGeoZip;

public class BaseRateRequest {

	@JsonIgnore
	private Boolean isZipQualifier;
	@JsonIgnore
	private GeoCityGeoZip originZip;
	@JsonIgnore
	private GeoCityGeoZip destZip;

	public BaseRateRequest() {

	}

	public GeoCityGeoZip getDestZip() {
		return destZip;
	}

	public Boolean getIsZipQualifier() {
		return isZipQualifier;
	}

	public GeoCityGeoZip getOriginZip() {
		return originZip;
	}

	public void setDestZip(GeoCityGeoZip destZip) {
		this.destZip = destZip;
	}

	public void setIsZipQualifier(Boolean isZipQualifier) {
		this.isZipQualifier = isZipQualifier;
	}

	public void setOriginZip(GeoCityGeoZip originZip) {
		this.originZip = originZip;
	}

}