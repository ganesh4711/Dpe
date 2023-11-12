package com.imaginnovate.dpe.properties;

import io.smallrye.config.ConfigMapping;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.Getter;
import org.eclipse.microprofile.config.inject.ConfigProperties;

@Getter
@ConfigProperties(prefix = "rtengine.truckstop")
public class TruckStopProperties {

	private String baseUrl;

	private String authEndPoint;

	private String username;

	private String password;

	private String base64EncodedId;

	private String providerId;

	private String rateEndPoint;

	private String batchRateEndPoint;

	public TruckStopProperties() {

	}

	public String getAuthInfo() {
		return "grant_type=password&username=" + this.username + "&" + "password=" + this.password;
	}

	public String getRefreshInfo(String token) {
		return "grant_type=refresh_token&refresh_token=" + token;
	}

	public void setAuthEndPoint(String authEndPoint) {
		this.authEndPoint = authEndPoint;
	}

	public void setBase64EncodedId(String base64EncodedId) {
		this.base64EncodedId = base64EncodedId;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public void setRateEndPoint(String rateEndPoint) {
		this.rateEndPoint = rateEndPoint;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setBatchRateEndPoint(String batchRateEndPoint) {
		this.batchRateEndPoint = batchRateEndPoint;
	}

}
