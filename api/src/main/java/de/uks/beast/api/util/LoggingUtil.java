package de.uks.beast.api.util;

import org.apache.log4j.Logger;

public class LoggingUtil {

	public static void fatal(String errorMessage, Logger logger) {
		logger.fatal(errorMessage);
		System.exit(1);
	}
	
	public static void fatal(Throwable e, String errorMessage, Logger logger) {
		logger.fatal(errorMessage, e);
		System.exit(1);
	}
	
}
