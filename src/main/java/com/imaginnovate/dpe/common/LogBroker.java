package com.imaginnovate.dpe.common;

import com.rollbar.notifier.Rollbar;
import jakarta.inject.Inject;



import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//@ConfigProperties(prefix = "rtengine.common")
final public class LogBroker {

	private final Logger logger = LoggerFactory.getLogger(LogBroker.class);
@ConfigProperty(name = "rtengine.common")
	private Boolean isRollBarEnabled;
	@ConfigProperty(name = "rtengine.common.enable.file.logger")
	private Boolean isFileLoggerEnabled;

	@Inject
	private Rollbar rollbar;

	public void error(String message, String className) {

		System.out.println(className + " -- " + message);

		if (isRollBarEnabled) {
			rollbar.error(message + "---" + className);
		}

		if (isFileLoggerEnabled) {
			logger.error(message);
		}
	}

	public void info(String message, String className) {

		System.out.println(className + " -- " + message);

		if (isFileLoggerEnabled) {
			logger.info(message);
		}
	}

}
