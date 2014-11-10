package de.uks.beast.server.util;

import org.apache.log4j.Logger;

public class LoggingUtil {

	public static void fatal(Throwable e, String errorMessage, Logger logger) {
		logger.fatal(errorMessage, e);
		System.exit(1);
	}
	
}
