package com.imaginnovate.dpe.data.response;

import lombok.Data;

import java.util.Date;

@Data
public class DATErrorInfo {

	private String id;

	private String message;

	private String appName;

	private Date dateTime;

	private String keyword;

	private String dataPath;

}
