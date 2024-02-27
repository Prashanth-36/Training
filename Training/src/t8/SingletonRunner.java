package t8;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class SingletonRunner {

	static Logger logger = Logger.getLogger(SingletonRunner.class.getName());

	public static void main(String[] args) {

		try {
			FileHandler fileHandler = new FileHandler("SingletonRunner.log");
			fileHandler.setFormatter(new SimpleFormatter());
			logger.addHandler(fileHandler);
			logger.setUseParentHandlers(false);
		} catch (SecurityException | IOException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, e.getMessage(), e);
		}

		Singleton obj1 = Singleton.INSTANCE;
		obj1.setName("objname");
		System.out.println(obj1.getName());
		logger.info(obj1.getName());

		Singleton obj2 = Singleton.INSTANCE;
		System.out.println(obj2.getName());
		logger.info(obj2.getName());

		SingletonClass obj = SingletonClass.getInstance();
		System.out.println(obj.getName());
		logger.info(obj.getName());

		try {
			obj.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, e.getMessage(), e);
		}

	}
}
