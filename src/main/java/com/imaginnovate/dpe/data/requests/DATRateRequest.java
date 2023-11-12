package com.imaginnovate.dpe.data.requests;


import com.imaginnovate.dpe.common.RSConstants;

public class DATRateRequest {

	public static class DATRequestBuilder {

		private final String vechicleType;

		private final Double duration;

		private final String country;

		private DATAreaInfo origin;

		private DATAreaInfo destination;

		public DATRequestBuilder(String v, String c, Double d) {
			this.vechicleType = v;
			this.country = c;
			this.duration = d;
		}

		public DATRateRequest build() {
			DATRateRequest rt = new DATRateRequest();
			DATEscalationInfo esc = new DATEscalationInfo();
			if (duration == 0.0) {
				esc.setEscalationType(RSConstants.DATDefaultEsc);
			} else {
				esc.setSpecificTimeFrame(String.format("%d_DAYS", duration.longValue()));
			}
			rt.setOrigin(origin);
			rt.setDestination(destination);
			rt.setTargetEscalation(esc);
			rt.setEquipment(vechicleType);
			//System.out.println("::getOrigin::"+rt.getOrigin().getPostalCode()+"::getDestination::"+rt.getDestination().getPostalCode()+"::getTargetEscalation::"+rt.getTargetEscalation().toString()+"::getEquipment:"+rt.getEquipment().toString());
			return rt;
		}

		public DATRequestBuilder destination(String postalCode) {
			this.destination = new DATAreaInfo();
			this.destination.setPostalCode(postalCode);
			this.origin.setCountry(country);
			return this;
		}

		public DATRequestBuilder destination(String city, String state) {
			this.destination = new DATAreaInfo();
			this.destination.setCity(city);
			this.destination.setStateOrProvince(state);
			this.origin.setCountry(country);
			return this;
		}

		public DATRequestBuilder origin(String postalCode) {
			this.origin = new DATAreaInfo();
			this.origin.setPostalCode(postalCode);
			this.origin.setCountry(country);
			return this;
		}

		public DATRequestBuilder origin(String city, String state) {
			this.origin = new DATAreaInfo();
			this.origin.setCity(city);
			this.origin.setStateOrProvince(state);
			this.origin.setCountry(country);
			return this;
		}

	}

	private DATAreaInfo origin;

	private DATAreaInfo destination;

	private DATEscalationInfo targetEscalation;

	private String rateType = "SPOT";

	private String equipment;

	private Boolean includeMyRate = false;

	private DATRateTense rateTimePeriod = new DATRateTense();

	public DATRateRequest() {
	}

	public DATAreaInfo getDestination() {
		return destination;
	}

	public String getEquipment() {
		return equipment;
	}

	public Boolean getIncludeMyRate() {
		return includeMyRate;
	}

	public DATAreaInfo getOrigin() {
		return origin;
	}

	public DATRateTense getRateTimePeriod() {
		return rateTimePeriod;
	}

	public String getRateType() {
		return rateType;
	}

	public DATEscalationInfo getTargetEscalation() {
		return targetEscalation;
	}

	public void setDestination(DATAreaInfo destination) {
		this.destination = destination;
	}

	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}

	public void setIncludeMyRate(Boolean includeMyRate) {
		this.includeMyRate = includeMyRate;
	}

	public void setOrigin(DATAreaInfo origin) {
		this.origin = origin;
	}

	public void setRateTimePeriod(DATRateTense rateTimePeriod) {
		this.rateTimePeriod = rateTimePeriod;
	}

	public void setRateType(String rateType) {
		this.rateType = rateType;
	}

	public void setTargetEscalation(DATEscalationInfo targetEscalation) {
		this.targetEscalation = targetEscalation;
	}

}
