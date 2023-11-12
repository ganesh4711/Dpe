package com.imaginnovate.dpe.contracts;


import com.imaginnovate.dpe.data.requests.RateRequest;

import java.util.Date;

public interface IRateSearch extends IRefreshToken {
	/**
	 * Authorize against rate provider
	 *
	 * @return String -Jwt token
	 */

	ProviderFeedBack authorize();

	/**
	 * Get unique provider Id;
	 *
	 * @return String
	 */

	String getProviderId();

	/**
	 * Fetch from the provider
	 *
	 * @return RateResponse
	 */

	ProviderFeedBack getRate(RateRequest rateRequest, Double duration);

	/**
	 * Gets authorization token
	 *
	 * @return
	 */
	String getToken();

	/**
	 * Sets authorization token
	 *
	 * @param token
	 */
	void setToken(String token);

	Date getExpiresWhen();

	void setExpiresWhen(Date exprireTime);

}
