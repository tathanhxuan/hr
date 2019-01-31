package com.hr.logging;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class WriterToFileLogger {

	public enum LogLevel {
		INFO, DEBUG, WARNING, ERROR, FUNCTIONAL_MESSAGE, FUNCTIONAL_ERROR;

		public static LogLevel[] all() {
			return values();
		}
	}

	private final Logger logger = Logger.getLogger(WriterToFileLogger.class.getName());
	private FileHandler fh = null;

	public static final String OUTPUT_DIR = System.getProperty("user.dir") + "/src/main/java/com/hr/logging/";

	public WriterToFileLogger() {
		SimpleDateFormat format = new SimpleDateFormat("M-d_HHmmss");
		try {
			fh = new FileHandler(OUTPUT_DIR + format.format(Calendar.getInstance().getTime()) + ".log");
		} catch (Exception e) {
			e.printStackTrace();
		}

		fh.setFormatter(new SimpleFormatter());
		logger.addHandler(fh);
	}

	public void doLogging(String msg, com.hr.logging.ILogger.LogLevel severity) {

		if (severity.toString().equals("WARNING")) {
			logger.warning(msg);
		} else if (severity.toString().equals("ERROR")) {
			logger.severe(msg);
		} else {
			logger.info(msg);
		}
	}

	public void infoMessage(String msg) {
		logger.info(msg);
	}

	public void warningMessage(String msg) {
		logger.warning(msg);
	}

	public void errorMessage(String msg) {
		logger.severe(msg);
	}
}
