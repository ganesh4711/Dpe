package com.imaginnovate.dpe.properties;

import io.smallrye.config.ConfigMapping;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperties;
@ApplicationScoped
@ConfigProperties(prefix = "rtengine.dat")
public class DatProperties {

	private String identityBaseUrl;

	private String userTokenEndpoint;

	private String serviceTokenEndpoint;

	private String rateLookupUrl;

	private String serviceUsername;

	private String servicePassword;

	private String username;

	/**
	 * Unique provider Id;
	 */
	private String providerId;

	public DatProperties() {

	}

	public String getIdentityBaseUrl() {
		return identityBaseUrl;
	}

	public String getProviderId() {
		return providerId;
	}

	public String getRateLookupUrl() {
		return rateLookupUrl;
	}

	public String getServicePassword() {
		return servicePassword;
	}

	public String getServiceTokenEndpoint() {
		return serviceTokenEndpoint;
	}

	public String getServiceUsername() {
		return serviceUsername;
	}

	public String getUsername() {
		return username;
	}

	public String getUserTokenEndpoint() {
		return userTokenEndpoint;
	}

	public void setIdentityBaseUrl(String identityBaseUrl) {
		this.identityBaseUrl = identityBaseUrl;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public void setRateLookupUrl(String rateLookupUrl) {
		this.rateLookupUrl = rateLookupUrl;
	}

	public void setServicePassword(String servicePassword) {
		this.servicePassword = servicePassword;
	}

	public void setServiceTokenEndpoint(String serviceTokenEndpoint) {
		this.serviceTokenEndpoint = serviceTokenEndpoint;
	}

	public void setServiceUsername(String serviceUsername) {
		this.serviceUsername = serviceUsername;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setUserTokenEndpoint(String userTokenEndpoint) {
		this.userTokenEndpoint = userTokenEndpoint;
	}

}
