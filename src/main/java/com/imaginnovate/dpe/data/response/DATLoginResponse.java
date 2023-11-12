package com.imaginnovate.dpe.data.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
public class DATLoginResponse {

	private String accessToken;

	private Date expiresWhen;

}
