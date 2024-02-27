package utility;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import myException.InvalidValueException;

public class Utils {

	public static void checkNull(Object obj) throws InvalidValueException {
		if (obj == null) {
			throw new InvalidValueException("Input cannot be null.");
		}
	}

	public static void checkRange(int min, int value, int max, String message) throws InvalidValueException {
		if (value < min || value > max) {
			throw new InvalidValueException(message);
		}
	}

	public static void checkRange(int min, int value, int max) throws InvalidValueException {
		checkRange(min, value, max, "Invalid input given value is not within acceptable range");
	}

	public static Logger customLogger(Logger logger, String fileName) {
		try {
			FileHandler handler = new FileHandler(fileName);
			handler.setFormatter(new SimpleFormatter());
			logger.addHandler(handler);
			ConsoleHandler handler2 = new ConsoleHandler();
			handler2.setFormatter(new SimpleFormatter() {
				@Override
				public String format(LogRecord record) {
					return record.getMessage() + System.lineSeparator();
				}
			});
			logger.addHandler(handler2);
		} catch (SecurityException | IOException e) {
			logger.log(Level.SEVERE, "File Handler exception", e);
		}
		logger.setUseParentHandlers(false);
		return logger;
	}

}
