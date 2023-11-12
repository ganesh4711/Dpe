package com.imaginnovate.dpe.data.response;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SonarLoginResponse implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -7064228977076579717L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private String username;

	private String token;

	private Double maxRecordsAllowed;

	private Date tokenExpirationDate;
}
