package t8;

import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class FileRunner {

	static Logger logger = Logger.getLogger(FileRunner.class.getName());

	public static void main(String[] args) {

		FileOperations fileHandler = new FileOperations();
		try {

			FileHandler handler = new FileHandler("FileRunner.log");
			handler.setFormatter(new SimpleFormatter());
			logger.addHandler(handler);
			logger.setUseParentHandlers(false);

			String content[] = new String[] { "Programmatically created file",
					"These words were written programmatically.", "All is Well. Be happy & enjoy the moment." };

			fileHandler.writeFile(System.getProperty("user.dir"), "sample.txt", content, false);

			System.out.println("from working dir");
			String read1 = fileHandler.readFile(System.getProperty("user.dir"), "sample.txt");
			System.out.println(read1);
			logger.info(read1);

			Properties props = new Properties();
			props.setProperty("name", "dell");
			props.setProperty("color", "black");
			props.setProperty("model", "precision");

			fileHandler.store(System.getProperty("user.dir"), "myprops.txt", props, "Laptop specifications.");

			Properties loadedProps = new Properties();
			fileHandler.load(System.getProperty("user.dir"), "myprops.txt", loadedProps);
			loadedProps.list(System.out);

			String homeDir = System.getProperty("user.home");

			fileHandler.mkdirs(homeDir + "/myDir/");

			fileHandler.writeFile(homeDir + "/myDir/", "sample.txt", content, false);

			fileHandler.store(homeDir + "/myDir/", "myprops.txt", loadedProps, "Laptop specs.");

			String read2 = fileHandler.readFile(homeDir + "/myDir/", "sample.txt");
			System.out.println("\nfrom home dir:" + read2);
			logger.info("\nfrom home dir:" + read2);

			Properties loadeProperties2 = new Properties();

			fileHandler.load(homeDir + "/myDir/", "myprops.txt", loadeProperties2);

			loadeProperties2.list(System.out);

		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
	}
}
