package t8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import myException.InvalidValueException;
import utility.Utils;

public class FileOperations {

	public void writeFile(String directory, String fileName, String content[], boolean append)
			throws InvalidValueException {
		Utils.checkNull(fileName);
		Utils.checkNull(directory);
		Utils.checkNull(content);
		try (BufferedWriter writer = new BufferedWriter(
				new FileWriter(directory + File.separator + fileName, append))) {
			for (String line : content) {
				writer.write(line);
				writer.newLine();
			}
		} catch (IOException e) {
			throw new InvalidValueException("Writing failed", e);
		}
	}

	public String readFile(String directory, String fileName) throws InvalidValueException {
		Utils.checkNull(fileName);
		Utils.checkNull(directory);
		try (BufferedReader reader = new BufferedReader(new FileReader(directory + File.separator + fileName))) {
			StringBuilder content = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				content.append(line);
				content.append(System.getProperty("line.separator"));
			}
			return content.toString();
		} catch (IOException e) {
			throw new InvalidValueException("Reading Failed.", e);
		}
	}

	public void mkdirs(String directory) throws InvalidValueException {
		Utils.checkNull(directory);
		File file = new File(directory);
		file.mkdirs();
	}

	public void store(String directory, String fileName, Properties props, String comments)
			throws InvalidValueException {
		Utils.checkNull(fileName);
		Utils.checkNull(props);
		Utils.checkNull(comments);
		try {
			props.store(new FileWriter(directory + File.separator + fileName), comments);
		} catch (IOException e) {
			throw new InvalidValueException("Storing props error.", e);
		}
	}

	public void load(String directory, String fileName, Properties props) throws InvalidValueException {
		Utils.checkNull(fileName);
		Utils.checkNull(props);
		Utils.checkNull(directory);
		try {
			props.load(new FileReader(directory + File.separator + fileName));
		} catch (IOException e) {
			throw new InvalidValueException("loading props error.", e);
		}
	}

}
