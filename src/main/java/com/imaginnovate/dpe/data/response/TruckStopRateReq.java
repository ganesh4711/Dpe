package com.imaginnovate.dpe.data.response;

import com.imaginnovate.dpe.data.requests.TSLaneInfo;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class TruckStopRateReq {

	public static class TSRequestBuilder {

		private final String timeFrameFromDate;
		private final String timeFrameToDate;
		private final String calculatedRateFormula;
		private TSLaneInfo lane;

		public TSRequestBuilder(String tffd, String tftd, String rateFormula) {
			this.timeFrameFromDate = tffd;
			this.timeFrameToDate = tftd;
			this.calculatedRateFormula = rateFormula;
			this.lane = new TSLaneInfo();
		}

		public TruckStopRateReq build() {
			TruckStopRateReq req = new TruckStopRateReq();
			req.setTimeFrameFromDate(timeFrameFromDate);
			req.setTimeFrameToDate(timeFrameToDate);
			req.setCalculatedRateFormula(calculatedRateFormula);
			req.setLane(Arrays.asList(lane));
			return req;
		}

		public TSRequestBuilder city(String ocity, String dcity, String ostate, String dstate) {
			lane.setOriginCity(ocity);
			lane.setOriginState(ostate);
			lane.setDestinationCity(dcity);
			lane.setDestinationState(dstate);
			return this;
		}

		public TSRequestBuilder country(String country) {
			lane.setOriginCountry(country);
			lane.setDestinationCountry(country);
			return this;
		}

		public TSRequestBuilder equipment(String toe, String eg) {
			lane.setTypeOfEquipments(toe);
			lane.setEquipmentGroup(eg);
			return this;
		}

		public TSRequestBuilder mode(String mode) {
			lane.setMode(mode);
			return this;
		}

		public TSRequestBuilder rateType(String rateType) {
			lane.setRateType(rateType);
			return this;
		}

		public TSRequestBuilder zip(String originZip, String destZip) {
			lane.setOriginZip(originZip);
			lane.setDestinationZip(destZip);
			return this;
		}

	}
	private List<TSLaneInfo> lane;
	private String calculatedRateFormula;
	private String timeFrameFromDate;

	private String timeFrameToDate;

	public TruckStopRateReq() {

	}

	public void setCalculatedRateFormula(String calculatedRateFormula) {
		this.calculatedRateFormula = calculatedRateFormula;
	}

}
