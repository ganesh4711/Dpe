package com.imaginnovate.dpe.data.response;


import lombok.Data;

@Data
public class TruckStopAuthRes {

	private String access_token;

	private String token_type;

	private Integer expires_in;

	private String refresh_token;

	public TruckStopAuthRes() {

	}

}
