package com.imaginnovate.dpe.properties;

import io.smallrye.config.ConfigMapping;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.Getter;
import org.eclipse.microprofile.config.inject.ConfigProperties;

@Getter
@ConfigProperties(prefix = "rtengine.sonar")
public class SonarFrieghtProperties {

	private String baseEndPoint;

	private String loginEndPoint;

	private String rateEndPoint;

	private String loginUserName;

	private String loginUserKey;

	/**
	 * Unique ID for rate providers
	 *
	 */

	private String providerId;

	public String getLoginURL() {
		return (this.baseEndPoint + this.loginEndPoint);
	}

	public String getRateURL(String fromDate, String toDate) {
		return (this.baseEndPoint + this.rateEndPoint + "/" + fromDate + "/" + toDate);
	}

	public String getRateURL() {
		return (this.baseEndPoint + this.rateEndPoint);
	}

	public void setBaseEndPoint(String baseEndPoint) {
		this.baseEndPoint = baseEndPoint;
	}

	public void setLoginEndPoint(String loginEndPoint) {
		this.loginEndPoint = loginEndPoint;
	}

	public void setLoginUserKey(String loginUserKey) {
		this.loginUserKey = loginUserKey;
	}

	public void setLoginUserName(String loginUserName) {
		this.loginUserName = loginUserName;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public void setRateEndPoint(String rateEndPoint) {
		this.rateEndPoint = rateEndPoint;
	}

}
