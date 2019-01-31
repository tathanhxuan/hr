package com.hr.logging;

public interface ILogger {
	public enum LogLevel {
		INFO, DEBUG, WARNING, ERROR, FUNCTIONAL_MESSAGE, FUNCTIONAL_ERROR;

		public static LogLevel[] all() {
			return values();
		}
	}

	abstract void message(String msg, LogLevel severity);

	default ILogger appendNext(ILogger nextLogger) {
		return (msg, severity) -> {
			message(msg, severity);
			nextLogger.message(msg, severity);
		};
	}
}