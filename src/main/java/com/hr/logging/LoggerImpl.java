package com.hr.logging;

import java.util.EnumSet;
import java.util.Set;
import java.util.function.Consumer;

public class LoggerImpl implements ILogger {

	@Override
	public void message(String msg, LogLevel severity) {
		// TODO Auto-generated method stub
		var logger = consoleLogger(LogLevel.all())
				.appendNext(emailLogger(LogLevel.FUNCTIONAL_MESSAGE, LogLevel.FUNCTIONAL_ERROR))
				.appendNext(fileLogger(LogLevel.WARNING, LogLevel.ERROR));

		// Handled by consoleLogger and emailLogger
		logger.message(msg, severity);
		WriterToFileLogger wtfLogger = new WriterToFileLogger();
		wtfLogger.doLogging(msg, severity);
	}

	private static ILogger logger(LogLevel[] levels, Consumer<String> writeMessage) {
		var set = EnumSet.copyOf(Set.of(levels));
		return (msg, severity) -> {
			if (set.contains(severity)) {
				writeMessage.accept(msg);
			}
		};
	}

	static ILogger consoleLogger(LogLevel... levels) {
		return logger(levels, msg -> System.err.println("Writing to console: " + msg));
	}

	static ILogger emailLogger(LogLevel... levels) {
		return logger(levels, msg -> System.err.println("Sending via email: " + msg));
	}

	static ILogger fileLogger(LogLevel... levels) {
		return logger(levels, msg -> System.err.println("Writing to log file: " + msg));

	}

}
