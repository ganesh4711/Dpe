package com.imaginnovate.dpe.data.requests;

import java.io.Serializable;

public class ProviderLoginRequest implements Serializable {

	/**
	 *
	 */
	static final long serialVersionUID = -6191440349454297895L;

	private String username;

	private String password;

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
