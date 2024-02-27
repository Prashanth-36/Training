package t8;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class POJORunner {

	static Logger logger = Logger.getLogger(POJORunner.class.getName());

	public static void main(String[] args) {

		try {
			FileHandler fileHandler = new FileHandler("POJORunner.log");
			fileHandler.setFormatter(new SimpleFormatter());
			logger.addHandler(fileHandler);
			logger.setUseParentHandlers(false);
		} catch (SecurityException | IOException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, e.getMessage(), e);
		}

		POJO pojo = new POJO(1, "myPojo");
		System.out.println(pojo);
		logger.info(pojo.toString());

		POJO pojo2 = new POJO();
		pojo2.setId(20);
		pojo2.setName("pojo2");

		String result = "id: " + pojo2.getId() + " name: " + pojo2.getName();
		System.out.println(result);
		logger.info(result);
	}
}
