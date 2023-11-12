package com.imaginnovate.dpe.contracts;


import com.imaginnovate.dpe.data.requests.RateRequest;
import com.imaginnovate.dpe.data.response.GenericRateResponse;
import com.imaginnovate.dpe.entities.LaneRateHistory;

import java.util.List;

public interface ILaneCache {

	/**
	 * Cache lanes and rates
	 *
	 * @param rtRequest
	 * @param grr
	 */
	public void cacheLane(RateRequest rtRequest, List<GenericRateResponse> grr);

	void cacheBatchLane(String originZipCode, String destZipCode, String equipmentType, GenericRateResponse grr);
	/**
	 *
	 * @param rtRequest
	 * @param pid
	 * @param duration
	 * @return LaneCacheRateInfo
	 */
	public LaneRateHistory getRate(RateRequest rtRequest, String pid, Double duration);


	LaneRateHistory getRateFromCache(String originZip, String destinationZip, String equipType, String pid, Double duration);

}
