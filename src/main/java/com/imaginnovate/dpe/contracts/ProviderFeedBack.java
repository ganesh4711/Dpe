package com.imaginnovate.dpe.contracts;

public abstract class ProviderFeedBack {

	public static final Integer feedBack200 = 200;

	public static final Integer feedBack201 = 201;

	public static final Integer feedBack401 = 401;

	public static final Integer feedBack403 = 403;

	public static final Integer feedBack500 = 500;

	public static final Integer feedBack503 = 503;

	public abstract Double getDuration();

	public abstract Integer getFeedBackCode();

	public abstract Object getFeedBackObject();

	public abstract Boolean getIsCacheSource();

	public abstract String providerId();

}
