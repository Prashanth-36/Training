package t8;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class EnumRunner {

	static Logger logger = Logger.getLogger(EnumRunner.class.getName());

	public static void main(String[] args) {
		try {
			FileHandler fileHandler = new FileHandler("EnumRunner.log");
			fileHandler.setFormatter(new SimpleFormatter());
			logger.addHandler(fileHandler);
			// fileHandler.
			logger.setUseParentHandlers(false);
		} catch (SecurityException | IOException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, e.getMessage(), e);
		}

		Rainbow rainbows[] = Rainbow.values();

		for (Rainbow rainbow : rainbows) {
			System.out.println(rainbow.ordinal() + " " + rainbow.getColorCode() + " " + rainbow);
			logger.info(rainbow.ordinal() + " " + rainbow.getColorCode() + " " + rainbow);
		}
	}
}
